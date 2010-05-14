package edu.ou.ece.cartracking.service

import java.util.Date

case class CarIdentifiedMsg(val sender: VideoCamera, val time: Date, val id: Long)