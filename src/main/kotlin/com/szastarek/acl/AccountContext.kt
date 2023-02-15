package com.szastarek.acl

import com.szastarek.acl.authority.Authority

interface AccountContext : AccountIdProvider, HasRole {
    val customAuthorities: List<Authority>
}