package com.projects.bigswierku.beerstagram.model.untapped

import com.google.gson.annotations.SerializedName

data class CheckInPost(
        val checkinComment: String,
        val checkinId: Int,
        val beerName : String,
        val beerStyle : String,
        val breweryName : String,
        val cityName: String,
        val bigPhotoUrl : String?,
        val smallPhotoUrl : String?,
        val rating: Int )