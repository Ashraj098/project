package com.ashish.slidingpuzzle.data

import androidx.room.*

@Dao
interface BestDataDao {
    @Query("SELECT * FROM puzzle_best_data")
     fun getAll(): List<BestData>?

    @Query("SELECT * FROM puzzle_best_data WHERE puzzleName IN (:names)")
     fun loadAllBy(names: Array<String>): List<BestData>?

    @Query("SELECT * FROM puzzle_best_data WHERE puzzleName is :puzzleName")
     fun findByPuzzle(puzzleName: String): BestData?

    @Insert
     fun newEntry(entry: BestData)

    @Update
     fun updateEntry(entry: BestData)

    @Delete
     fun delete(entry: BestData)

}