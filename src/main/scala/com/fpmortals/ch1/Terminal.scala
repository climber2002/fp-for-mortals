package com.fpmortals.ch1

trait Terminal[C[_]] {
  def read: C[String]
  def write(t: String): C[Unit]
}
