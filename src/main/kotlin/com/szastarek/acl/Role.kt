package com.szastarek.acl

import com.szastarek.acl.authority.Authority
import kotlinx.serialization.Serializable

@Serializable
sealed interface Role

@Serializable
data class RegularRole(val name: String, val authorities: List<Authority>) : Role

@Serializable
object SuperUserRole : Role
