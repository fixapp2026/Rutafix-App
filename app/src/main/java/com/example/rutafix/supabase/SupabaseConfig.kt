package com.example.rutafix.supabase

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.postgrest.Postgrest
import io.ktor.client.engine.android.Android

object SupabaseConfig {
    
    private const val SUPABASE_URL = "https://etjnzvgjfzeebthozvyi.supabase.co"
    private const val SUPABASE_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImV0am56dmdqZnplZWJ0aG96dnlpIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NzU1MTY2MDAsImV4cCI6MjA5MTA5MjYwMH0.GtM6ZUn8rMYUMYP2P-81s9enL3GOsWCLuWtYasWb1Ok"

    val client: SupabaseClient by lazy {
        createSupabaseClient(
            supabaseUrl = SUPABASE_URL,
            supabaseKey = SUPABASE_KEY
        ) {
            // Con Ktor 3.0, el motor se configura de esta manera
            httpEngine = Android.create()

            install(Auth)
            install(Postgrest)
        }
    }
}