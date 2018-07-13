package com.padcassignment.mmhealthcare.datas.vos

import com.google.gson.annotations.SerializedName

class AuthorsVO(@SerializedName("author-id") var authorId: Int = 0,
                @SerializedName("author-name") var authorName: String="",
                @SerializedName("author-picture") var authorPicture: String=""
)
{
}