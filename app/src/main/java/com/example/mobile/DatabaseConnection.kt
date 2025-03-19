package com.example.mobile

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object DatabaseConnection {

    private const val URL = "jdbc:postgresql://localhost:5432/AwalPemWeb"
    private const val USER = "postgres"
    private const val PASSWORD = "Mahir"

    fun connection (): Connection?{
        return try{
            Class.forName("org.postgresql.Driver")
            DriverManager.getConnection(URL,USER, PASSWORD).also {
                println("Koneksi Berhasil")
            }
        }catch (e: SQLException){
            e.printStackTrace()
            null
        }
    }
}
