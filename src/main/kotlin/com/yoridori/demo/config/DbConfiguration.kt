package com.yoridori.demo.config

import database.UserDynamicSqlSupport.age
import database.UserMapper
import database.select
import org.apache.ibatis.io.Resources
import org.apache.ibatis.session.SqlSessionFactory
import org.apache.ibatis.session.SqlSessionFactoryBuilder
import org.mybatis.dynamic.sql.select.QueryExpressionDSL
import org.mybatis.dynamic.sql.select.SelectModel
import org.mybatis.dynamic.sql.util.kotlin.KotlinSelectBuilder
import org.mybatis.dynamic.sql.util.kotlin.elements.isGreaterThanOrEqualTo

fun createSessionFactory(): SqlSessionFactory {
    val resource = "mybatis-config.xml"
    val inputStream = Resources.getResourceAsStream(resource)
    return SqlSessionFactoryBuilder().build(inputStream)
}

