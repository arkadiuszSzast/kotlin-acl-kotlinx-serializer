package com.szastarek.acl

import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

data class AuthenticatedAccountContext(val accountContext: AccountContext) :
    AbstractCoroutineContextElement(AuthenticatedAccountContext) {

    companion object Key : CoroutineContext.Key<AuthenticatedAccountContext>
}
