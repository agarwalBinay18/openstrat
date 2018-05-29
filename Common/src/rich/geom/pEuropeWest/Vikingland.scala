/* Copyright 2018 Richard Oliver. Licensed under Apache Licence version 2.0 */package rich
package geom
package pEuropeWest
import pEarth._
import Terrain._

object Jutland extends Area2('Jutland, 56.29 ll 9.33, plain)
{
   val swJutland = 53.89 ll 8.96
   val sanktPeterOrding = 54.32 ll 8.59
   val blavandshuk = 55.56 ll 8.07
   val ferring = 56.52 ll 8.11
   val hanstholm = 57.12 ll 8.61
   val slettestrand = 57.15 ll 9.37
   val hirtshals = 57.59 ll 9.95
   val wSkivern = 57.61 ll 10.25
   val skagen = 57.71 ll 10.52
   val albaek = 57.59 ll 10.42
   val hevring = 56.52 ll 10.41
   val grenaa = 56.53 ll 10.83
   val kirkeskov = 55.63 ll 9.86   
   
   val funenN = 55.62 ll 10.30
   val nyborg = 55.29 ll 10.85   
   val lubeck = 53.97 ll 10.84
   
   val latLongs = LatLongs(swJutland, sanktPeterOrding, blavandshuk, ferring, hanstholm,
         slettestrand, hirtshals, wSkivern, skagen, albaek, hevring, grenaa, kirkeskov, funenN, nyborg, lubeck)
}

object Zealand extends Area2('Zealand, 55.58 ll 11.90, plain)
{
   
   val zealandN = 56.13 ll 12.29
   val helsingor = 56.04 ll 12.62
   val mikkelborg = 55.91 ll 12.51
   val copenhagen = 55.62 ll 12.68
   val gedser = 54.56 ll 11.97
   val nakskov = 54.76 ll 11.00
   val zealandNW = 55.74 ll 10.87
   
   val latLongs = LatLongs(zealandN, helsingor, mikkelborg, copenhagen, gedser, nakskov, zealandNW)   
} 



object Scandanavia extends Area2('Scandanavia, 62.75 ll 14.30, taiga)
{
   
   val haparanda = 65.77 ll 24.17
   val ranea = 65.86 ll 22.36
   
   val eLappviken = 64.44 ll 21.60
   val gavie = 60.68 ll 17.21
   val kappelskar = 59.75 ll 19.08
   val herrhamra = 58.80 ll 17.84
   val hummelvik = 58.62 ll 17.01
   val torhamn = 56.07 ll 15.84
   val stenshamn = 56.01 ll 15.78
  
   val pukavik = 56.16 ll 14.68
   val ahus = 55.92 ll 14.32
   val simrishamn = 55.55 ll 14.35
   val sandhammaren = 55.38 ll 14.19
   val vellinge = 55.41 ll 13.02
   val helsingborg = 56.04 ll 12.69
   val kullens = 56.30 ll 12.44
   val torekov = 56.42 ll 12.62
   val bastad = 56.43 ll 12.85
   val andersberg = 56.65 ll 12.87
   val sTylosand = 56.64 ll 12.72
   val wHono = 57.69 ll 11.60   
   
   val oslo = 59.57 ll 10.59
   val nevlunghavn = 58.96 ll 9.85
   val lindesnes = 57.98 ll 7.05
   val flekkeroy = 58.06 ll 8.00
   
   val steinhodden = 58.11 ll 6.55
   val bryne = 58.75 ll 5.49
   val rennesoy = 59.12 ll 5.56   
   val swKarmoy = 59.14 ll 5.19
   val ytreSula = 61.04 ll 4.63
   val bremangerlandet = 61.85 ll 4.82
   val wRunde = 62.41 ll 5.58
   
   
   val svelllingen = 63.79 ll 8.68
   val uthaug = 63.72 ll 9.55
   val bodo = 67.26 ll 14.32
   
   
   val nordskot = 67.82 ll 14.70
   val wBaoya = 68.33 ll 16.03
   val w1 = 67.83 ll 12.82
   val andenes = 69.32 ll 16.11
   val gapoyholman = 68.88 ll 16.06
   
   val torsvag = 70.28 ll 19.59
   val nordkapp = 71.16 ll 25.78
   val lakselv = 70.05 ll 25.00
   
   val latLongs = LatLongs(haparanda, ranea, eLappviken, gavie, kappelskar, herrhamra, hummelvik, torhamn, stenshamn,
          pukavik, ahus, simrishamn, sandhammaren, vellinge, helsingborg, kullens, torekov, bastad, andersberg, sTylosand, wHono,
          oslo, nevlunghavn, flekkeroy, lindesnes,
          steinhodden, bryne, rennesoy, swKarmoy, ytreSula, bremangerlandet, wRunde,
          svelllingen, uthaug, bodo, nordskot, wBaoya, w1, andenes, gapoyholman,
          torsvag, nordkapp, lakselv)
}

object Faroe extends Area2('Faroe, 62.14 ll -6.91, taiga)
{
   val sSuduroy = 61.39 ll -6.68
   val wValgar = 62.3 ll -7.46
   val nEysturoy = 62.34 ll -6.98
   val eFugloy = 62.33 ll -6.25
   val latLongs = LatLongs(sSuduroy, wValgar, nEysturoy, eFugloy)
}

object JanMayen extends Area2('JanMayen, 71.02 ll -8.29, taiga)
{
   val south = 70.82 ll -9.03
   val west = 70.86 ll -9.07
   val susabu = 71.01 ll -8.46
   val point1 = 71.08 ll -8.38
   val northEast = 71.16 ll -7.94
   val southEast = 71.02 ll -7.98
   
   val latLongs = LatLongs(south, west, susabu, point1, northEast, southEast)
}

