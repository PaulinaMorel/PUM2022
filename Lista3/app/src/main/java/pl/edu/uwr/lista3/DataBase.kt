package pl.edu.uwr.lista3

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBase(context: Context) : SQLiteOpenHelper(
    context, DATABASE_NAME, null, DATABASE_VERSION
) {
    private companion object{
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "studentsDBKotlin.db"
        private const val TABLE_STUDENTS = "StudentTable"

        private const val COLUMN_ID = "_id"
        private const val COLUMN_NAME = "name"
        private const val COLUMN_INDEX = "indexNumber"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_STUDENTS_TABLE =
            "CREATE TABLE $TABLE_STUDENTS(" +
                    "$COLUMN_ID INTEGER PRIMARY KEY," +
                    "$COLUMN_NAME TEXT," +
                    "$COLUMN_INDEX INTEGER)"
        db?.execSQL(CREATE_STUDENTS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_STUDENTS")
        onCreate(db)
    }

    fun addRec(Lista:String, Punkty:Int){
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(COLUMN_NAME, Lista)
        contentValues.put(COLUMN_INDEX, Punkty)

        db.insert(TABLE_STUDENTS, null, contentValues)
        db.close()
    }

    fun deleteStudent(student: Lista){
        val db = this.writableDatabase

        db.delete(
            TABLE_STUDENTS,
            "$COLUMN_ID=${student.id}",
            null)
        db.close()
    }

    fun updateStudent (id: Int, name: String, index: Int){
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COLUMN_NAME, name)
        contentValues.put(COLUMN_INDEX, index)

        db.update(TABLE_STUDENTS,
            contentValues,
            "$COLUMN_ID=$id",
            null)

        db.close()
    }

    fun getStudents(): List<Lista> {
        val students: MutableList<Lista> = ArrayList()

        val db = this.readableDatabase

        val cursor = db.rawQuery("SELECT * FROM $TABLE_STUDENTS", null)

        if (cursor.moveToFirst()) {
            do {
                students.add(Lista(
                    cursor.getInt(0),
                cursor.getString(1),
                    cursor.getInt(2)
                ))
            } while (cursor.moveToNext())
        }

        db.close()
        cursor.close()
        return students
    }
}