package com.fpmortals.buildfarm

trait Drone[F[_]] {
  def getBacklog: F[Int]

  def getAgents: F[Int]
}
