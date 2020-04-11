package com.fpmortals.buildfarm

import scalaz.NonEmptyList

object Data {
  val node1 = MachineNode("1243d1af-828f-4ba3-9fc0-a19d86852b5a")
  val node2 = MachineNode("550c4943-229e-47b0-b6be-3d686c5f013f")
  val managed = NonEmptyList(node1, node2)

  val time1: Epoch = epoch"2017-03-03T18:07:00Z"
  val time2: Epoch = epoch"2017-03-03T18:59:00Z" // +52 mins
  val time3: Epoch = epoch"2017-03-03T19:06:00Z" // +59 mins
  val time4: Epoch = epoch"2017-03-03T23:07:00Z" // +5 hours
  val needsAgents = WorldView(5, 0, managed, Map.empty, Map.empty, time1)


}
