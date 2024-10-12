package com.hcthang.apptuyendung.data.model

import com.hcthang.apptuyendung.data.model.job.Job
import java.io.Serializable

data class NotificationItem(var id : Int = 0 ,
                             var candidate : User? = null,
                             var job : Job? = null,
                             var avatarUser: AvatarUser? = null) : Serializable