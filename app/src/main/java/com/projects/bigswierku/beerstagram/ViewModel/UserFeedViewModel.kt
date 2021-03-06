package com.projects.bigswierku.beerstagram.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.projects.bigswierku.beerstagram.Api.UntappedRepo
import com.projects.bigswierku.beerstagram.model.untapped.FriendCheckIn
import com.projects.bigswierku.beerstagram.model.untapped.ResponseStatus
import com.projects.bigswierku.beerstagram.model.untapped.Status
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserFeedViewModel @Inject constructor(private val untappedRepo: UntappedRepo) : ViewModel(){


    private lateinit var disposable: Disposable

    var userFeedLiveData : MutableLiveData<List<FriendCheckIn>> = MutableLiveData()
    var responseStatus : MutableLiveData<ResponseStatus> = MutableLiveData()


    fun getUserFeed(token : String){
        disposable = untappedRepo.getFriendsCheckIns(token)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe{responseStatus.value =
                ResponseStatus(Status.SUCCESS)
            }
            .subscribe(
                {
                    userFeedLiveData.value = it.sortedByDescending { it.checkinId }
                    responseStatus.value =
                        ResponseStatus(Status.SUCCESS)
                },
                {responseStatus.value = ResponseStatus(
                    Status.ERROR,
                    it.message
                )
                }
            )
    }


    override fun onCleared() {
        super.onCleared()
        if(::disposable.isInitialized){
            disposable.dispose()
        }
    }
}