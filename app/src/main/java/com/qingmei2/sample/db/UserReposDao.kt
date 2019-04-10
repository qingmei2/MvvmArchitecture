package com.qingmei2.sample.db

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.qingmei2.sample.entity.Repo

@Dao
interface UserReposDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(repos: List<Repo>)

    @Query("SELECT * FROM user_repos ORDER BY indexInResponse ASC")
    fun queryRepos(): DataSource.Factory<Int, Repo>

    @Query("DELETE FROM user_repos")
    fun deleteAllRepos()

    @Query("SELECT MAX(indexInResponse) + 1 FROM user_repos")
    fun getNextIndexInRepos(): Int
}