package ostrat
package pParse

/** Function object for parsing expected Hexadecimal number. */
object Hexadecimal
{
  /** Function for parsing expected Hexadecimal number. */
  def apply(rem: CharsOff, tp: TextPosn)(implicit charArr: Chars): EMon[(CharsOff, TextPosn, IntHexaToken)] =
  {
    def hexIntLoop(rem: CharsOff, strAcc: String, intAcc: Long): EMon[(CharsOff, TextPosn, IntHexaToken)] = rem match
    { case CharsOff0() => Good3(rem, tp.addStr(strAcc), IntHexaToken(tp, strAcc, intAcc))
      case CharsOff1Tail(HexaDigitChar(c, i), tail) => hexIntLoop(tail, strAcc + c, intAcc * 16 + i)
      case CharsOff1Plus(LetterChar(_)) => bad1(tp, "Badly formed hexadecimal")
      case _ => Good3(rem, tp.addStr(strAcc), IntHexaToken(tp, strAcc, intAcc))
    }

    rem match
    { case CharsOff2Tail('0', 'x', tail) if tail.forN(16, _.isHexaDigit) => ??? //Needs big integer
      case CharsOff3Tail('0', 'x', HexaDigitChar(c, i), tail) => hexIntLoop (tail, "0x" + c, i)
      case CharsOff3Plus('0', 'x', WhitespaceChar(_)) => bad1(tp, "Empty hexademicmal token.")
      case CharsOff3Plus('0', 'x', c) => bad1(tp, "Badly formed hexademicmal token.")
      case CharsOff2('O', 'x') => bad1(tp, "Unclosed hexadecimal token")
    }
  }
}