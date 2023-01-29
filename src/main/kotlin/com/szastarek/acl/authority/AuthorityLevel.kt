package com.szastarek.acl.authority

import kotlinx.serialization.Serializable

@Serializable
enum class AuthorityLevel {
    View,
    Create,
    Update,
    Delete,
    Manage
}