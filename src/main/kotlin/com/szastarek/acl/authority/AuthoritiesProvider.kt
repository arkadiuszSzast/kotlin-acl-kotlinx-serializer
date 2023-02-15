package com.szastarek.acl.authority

interface AuthoritiesProvider {
    suspend fun getRoleAuthorities(): List<Authority>
    suspend fun getCustomAuthorities(): List<Authority>
    suspend fun getInjectedAuthorities(): List<Authority>

    suspend fun getJoinedAuthorities(): List<Authority> {
        return getRoleAuthorities()
            .mergeWith(getCustomAuthorities())
            .mergeWith(getInjectedAuthorities())
    }
}