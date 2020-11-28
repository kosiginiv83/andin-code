package ru.netology.nmedia.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import ru.netology.nmedia.entity.PostEntity

interface PostRepository: JpaRepository<PostEntity, Long> {
    @Modifying
    @Query("UPDATE PostEntity e SET e.likes = e.likes + 1 WHERE e.id = :id")
    fun likeById(@Param("id") id: Long): Int

    @Modifying
    @Query("UPDATE PostEntity e SET e.likes = e.likes - 1 WHERE e.id = :id")
    fun unlikeById(@Param("id") id: Long): Int
}