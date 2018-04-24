package karahito.jp.realmrepository.repository

import dagger.Binds
import dagger.Module

/**
 * RepositoryModule Class
 * RepositoryをBindするModuleクラス
 *
 * app moduleで使用する際にはDataModuleにInjectする。
 *
 * @author D.Noguchi
 * @since 2018/04/24
 */
@Module(includes = arrayOf(RealmRepositoryImp::class))
abstract class RepositoryModule {
    @Binds
    abstract internal fun bindRealmRepository(repositoryImp: RealmRepositoryImp):RealmRepository
}