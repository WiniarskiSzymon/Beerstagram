package com.projects.bigswierku.beerstagram.ViewModel

import com.projects.bigswierku.beerstagram.Api.UntappedAPI
import com.projects.bigswierku.beerstagram.model.untapped.CheckInPost
import com.projects.bigswierku.beerstagram.model.untapped.PubResponse
import com.projects.bigswierku.beerstagram.toPost
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import org.intellij.lang.annotations.Flow
import javax.inject.Inject

class CheckInsViewModel @Inject constructor(private val untappedAPI: UntappedAPI){


    fun getCheckIns() : Single<List<CheckInPost>> {
        return untappedAPI.getCheckIns().flatMap { Single.just ( it.response.checkins.items.flatMap {listOf(it.toPost())})}

    }



}