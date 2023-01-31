package com.szastarek.acl

import com.szastarek.acl.authority.Authority
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed interface Role

@Serializable
@SerialName("RegularRole")
data class RegularRole(val name: String, val authorities: List<Authority>) : Role

@Serializable
@SerialName("SuperUserRole")
object SuperUserRole : Role
