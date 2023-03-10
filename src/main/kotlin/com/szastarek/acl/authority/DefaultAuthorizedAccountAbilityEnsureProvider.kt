package com.szastarek.acl.authority

import com.szastarek.acl.Feature

class DefaultAuthorizedAccountAbilityEnsureProvider(
    private val acl: AuthorizedAccountAbilityProvider,
) : AuthorizedAccountAbilityEnsureProvider {
    override suspend fun ensureHasAccessTo(feature: Feature) {
        return when (val decision = acl.hasAccessTo(feature)) {
            is Allow -> Unit
            is Deny -> throw decision.reason
        }
    }

    override suspend fun <T : AclResource> ensureCanCreate(aclResource: T) {
        when (val decision = acl.canCreate(aclResource)) {
            is Allow -> Unit
            is Deny -> throw decision.reason
        }
    }

    override suspend fun <T : AclResource> ensureCanUpdate(aclResource: T) {
        when (val decision = acl.canUpdate(aclResource)) {
            is Allow -> Unit
            is Deny -> throw decision.reason
        }
    }

    override suspend fun <T : AclResource> ensureCanDelete(aclResource: T) {
        when (val decision = acl.canDelete(aclResource)) {
            is Allow -> Unit
            is Deny -> throw decision.reason
        }
    }

    override suspend fun <T : AclResource> ensureCanView(aclResource: T) {
        when (val decision = acl.canView(aclResource)) {
            is Allow -> Unit
            is Deny -> throw decision.reason
        }
    }

    override suspend fun <T : AclResource> filterCanView(entities: Collection<T>): Collection<T> {
        return acl.filterCanView(entities)
    }
}
