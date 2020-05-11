package org.hpi.esb.util

import org.scalatest.FunSuite
import org.scalatest.mockito.MockitoSugar

class OffsetManagementTest extends FunSuite with MockitoSugar {

  test("get number of messages") {
    assert(OffsetManagement.getNumberOfMessages("guenter1", 0) == 22)
  }

}
