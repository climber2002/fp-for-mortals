package com.fpmortals.buildfarm

import scalaz.{Scalaz, _}
import Scalaz._

class Mutable(state: WorldView) {
  var started, stopped: Int = 0

  private val D: Drone[Id] = new Drone[Id] {
    override def getBacklog: Int = state.backlog

    override def getAgents: Int = state.agents
  }

  private val M: Machines[Id] = new Machines[Id] {
    override def getAlive: Map[MachineNode, Epoch] = state.alive

    override def getTime: Id[Epoch] = state.time

    override def getManaged: Id[NonEmptyList[MachineNode]] = state.managed

    override def start(node: MachineNode): Id[MachineNode] = { started += 1; node }

    override def stop(node: MachineNode): Id[MachineNode] = { stopped += 1; node }
  }

  val program = new DynAgentsModule[Id](D, M)
}
