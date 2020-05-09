package ostrat
package pParse

/** Not entirely sure what this does. */
object PrefixPlus
{
  def apply(implicit refs: Arr[BlockMember]): ERefs[BlockMember] =
  {
    val acc: Buff[BlockMember] = Buff()

    def loop(rem: ArrOff[BlockMember]): ERefs[BlockMember] = rem match
    { case ArrOff0() => Good(acc).map(_.toRefs)
      //case RefsOff2Tail(pp: PrefixToken,  right: Expr, tail) => { acc.append(PreOpExpr(pp, right)); loop(tail) }
      //case RefsOffHead(pp: PrefixToken) => bad1(pp, "Prefix operator not followed by expression")
      case ArrOff1Tail(h, tail) => { acc.append(h); loop(tail) }
    }
    loop(refs.offset0)
  }
}

/** Needs Testing. */
object getExpr
{
  def apply (implicit seg: Arr[ClauseMember]): EMon[Expr] = fromOffset(seg.offset0)

  def fromOffset(inp: ArrOff[ClauseMember])(implicit seg: Arr[ClauseMember]): EMon[Expr] =
  {
    val acc: Buff[ClauseMember] = Buff()

    def loop(rem: ArrOff[ClauseMember]): EMon[Expr] = { rem match
    { case ArrOff0() => composeBlocks(acc.toRefs)

      case ArrOff1Tail(at @ AsignToken(_), tail) =>
        composeBlocks(acc.toRefs).flatMap(gLs => fromOffset(tail).map(gRs => AsignExpr(gLs, at, gRs)))
      /*{
        val eA = for {
          gLs <- composeBlocks(acc.toRefs)
          gRs <- fromOffset(tail) //This has been altered. I think its correct now with no altering to acc
        } yield AsignExpr(gLs, at, gRs)

        eA
      }*/
      case ArrOff1Tail(h, tail) => { acc.append(h); loop(tail) }
    } }
    loop(inp)
  }
}