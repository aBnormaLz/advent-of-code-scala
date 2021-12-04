package year2021

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike
import util.{Logger, Task}
import year2021.day4.BingoUtil

class Day4 extends Task(2021, 4) with AnyWordSpecLike with Matchers {
  implicit val log: Logger = new Logger(true)

  def part1(input: Seq[String]): Int = {
    val allWinningNumbers              = input.head.split(",").map(_.toInt)
    val rawTables                      = BingoUtil.parseBingos(input)
    val (winningTable, lastDrewNumber) = BingoUtil.findWinningTableAndLastNumber(rawTables, allWinningNumbers)

    winningTable.sumOfNotWinningNumbers() * lastDrewNumber
  }

  "Part 1" should {
    "solve the example" in {
      val input = getExample()
      part1(input) shouldBe 4512
    }

    "solve the task" in {
      val input = getTask()
      part1(input) shouldBe 65325
    }
  }
}