package chpater28_ObjectEquality

import org.scalatest.FunSuite

/**
 * Created by katsuki on 2014/09/14.
 */
class BranchTest extends FunSuite {
  val bottom1 = new Branch("bottom1",EmptyTree,EmptyTree)
  val bottom2 = new Branch("bottom2",EmptyTree,EmptyTree)

  test("同一性のテスト_Branchでない場合_false"){
    assert(bottom1 != EmptyTree)
  }

  test("同一性のテスト_Branchでelemが異なる場合_false"){
    assert(bottom1 != bottom2)
  }
  test("同一性のテスト_Branchでleftが異なる場合_false"){
    assert(new Branch("1",bottom1,bottom2) != new Branch("1",bottom2,bottom2))
  }
  test("同一性のテスト_Branchでrightが異なる場合_false"){
    assert(new Branch("1",bottom1,bottom2) != new Branch("1",bottom1,bottom1))
  }
  test("同一性のテスト_Branchでelem,left,rightが同じ場合_true"){
    assert(new Branch("1",bottom1,bottom2) == new Branch("1",bottom1,bottom2))
  }
  test("同一性のテスト_Branchの型パラメータのみ異なる場合_true"){
    assert(new Branch[List[String]](Nil,EmptyTree,EmptyTree) == new Branch[List[Int]](Nil,EmptyTree,EmptyTree))
  }
}
