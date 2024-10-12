package com.b15d52nhom4.apptuyendung.data.model

import com.b15d52nhom4.apptuyendung.data.model.job.Job
import java.io.Serializable

data class NotificationItem(var id : Int = 0 ,
                             var candidate : User? = null,
                             var job : Job? = null,
                             var avatarUser: AvatarUser? = null) : Serializable