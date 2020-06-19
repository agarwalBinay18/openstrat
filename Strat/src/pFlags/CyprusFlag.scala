package ostrat
package pFlags
import geom._, Colour._

object Cyprus extends Flag
{ val name = "Cyprus"
  val ratio = 1.5

  val apply =
  {
    val background = Rectangle(1.5, 1).fill(White)
    val map = PolyCurve(LineSeg(0.4619 vv 0.3267), LineSeg(0.458 vv 0.3252), LineSeg(0.4564 vv 0.3245), LineSeg(0.4517 vv 0.3248), LineSeg(0.4472 vv 0.3227), LineSeg(0.4393 vv 0.3173), LineSeg(0.439 vv 0.317), LineSeg(0.436 vv 0.3163), LineSeg(0.4333 vv 0.3174), LineSeg(0.4317 vv 0.3167), LineSeg(0.4312 vv 0.3135), LineSeg(0.4297 vv 0.3112), LineSeg(0.4279 vv 0.3099), LineSeg(0.4216 vv 0.3093), LineSeg(0.4163 vv 0.3066), LineSeg(0.4094 vv 0.3084), LineSeg(0.4061 vv 0.3072), LineSeg(0.3993 vv 0.301), LineSeg(0.3958 vv 0.2993), LineSeg(0.3946 vv 0.2994), LineSeg(0.39 vv 0.2997), LineSeg(0.388 vv 0.299), LineSeg(0.3851 vv 0.2962), LineSeg(0.3796 vv 0.2958), LineSeg(0.3778 vv 0.2946), LineSeg(0.3752 vv 0.2891), LineSeg(0.3722 vv 0.2861), LineSeg(0.3706 vv 0.2858), LineSeg(0.3687 vv 0.2864), LineSeg(0.3674 vv 0.2862), LineSeg(0.3668 vv 0.2827), LineSeg(0.3654 vv 0.2813), LineSeg(0.3617 vv 0.28), LineSeg(0.3588 vv 0.2775), LineSeg(0.3562 vv 0.2762), LineSeg(0.3527 vv 0.2763), LineSeg(0.3527 vv 0.2771), LineSeg(0.3493 vv 0.2752), LineSeg(0.3428 vv 0.2746), LineSeg(0.3401 vv 0.272), LineSeg(0.3395 vv 0.2715), LineSeg(0.3382 vv 0.2707), LineSeg(0.3361 vv 0.2695), LineSeg(0.3356 vv 0.2692), LineSeg(0.3331 vv 0.2696), LineSeg(0.3302 vv 0.2685), LineSeg(0.329 vv 0.2703), LineSeg(0.327 vv 0.2691), LineSeg(0.3243 vv 0.2689), LineSeg(0.321 vv 0.2704), LineSeg(0.3185 vv 0.2716), LineSeg(0.3166 vv 0.2713), LineSeg(0.316 vv 0.2681), LineSeg(0.3159 vv 0.2677), LineSeg(0.314 vv 0.2651), LineSeg(0.3103 vv 0.2629), LineSeg(0.3098 vv 0.2623), LineSeg(0.3057 vv 0.2569), LineSeg(0.2978 vv 0.2486), LineSeg(0.2912 vv 0.2453), LineSeg(0.2843 vv 0.2432), LineSeg(0.2794 vv 0.2392), LineSeg(0.2668 vv 0.2329), LineSeg(0.2468 vv 0.223), LineSeg(0.2427 vv 0.2217), LineSeg(0.2368 vv 0.2207), LineSeg(0.2264 vv 0.2169), LineSeg(0.2171 vv 0.2141), LineSeg(0.2166 vv 0.2139), LineSeg(0.2148 vv 0.2134), LineSeg(0.2018 vv 0.2094), LineSeg(0.1957 vv 0.2101), LineSeg(0.1921 vv 0.2088), LineSeg(0.1828 vv 0.2098), LineSeg(0.1763 vv 0.2097), LineSeg(0.1722 vv 0.2088), LineSeg(0.1644 vv 0.2051), LineSeg(0.1514 vv 0.1989), LineSeg(0.1471 vv 0.1949), LineSeg(0.1404 vv 0.1914), LineSeg(0.1325 vv 0.1889), LineSeg(0.1325 vv 0.1922), LineSeg(0.1325 vv 0.1924), LineSeg(0.1298 vv 0.1915), LineSeg(0.1278 vv 0.1909), LineSeg(0.1214 vv 0.1899), LineSeg(0.1214 vv 0.1934), LineSeg(0.1192 vv 0.1941), LineSeg(0.1189 vv 0.194), LineSeg(0.1058 vv 0.1897), LineSeg(0.09132 vv 0.1883), LineSeg(0.08405 vv 0.1859), LineSeg(0.07861 vv 0.186), LineSeg(0.07522 vv 0.185), LineSeg(0.06856 vv 0.1842), LineSeg(0.06618 vv 0.1848), LineSeg(0.06564 vv 0.185), LineSeg(0.04606 vv 0.1841), LineSeg(0.0371 vv 0.1851), LineSeg(0.03283 vv 0.1842), LineSeg(0.02567 vv 0.1866), LineSeg(0.01522 vv 0.1878), LineSeg(0.01278 vv 0.1885), LineSeg(0.00729 vv 0.1902), LineSeg(0.004805 vv 0.1887), LineSeg(0.002945 vv 0.1885), LineSeg(-0.0015 vv 0.1901), LineSeg(-0.0031 vv 0.1902), LineSeg(-0.00677 vv 0.1889), LineSeg(-0.008882 vv 0.1894), LineSeg(-0.01084 vv 0.191), LineSeg(-0.01545 vv 0.1916), LineSeg(-0.01825 vv 0.194), LineSeg(-0.03392 vv 0.1919), LineSeg(-0.03817 vv 0.1932), LineSeg(-0.05243 vv 0.1973), LineSeg(-0.0547 vv 0.1972), LineSeg(-0.05752 vv 0.1951), LineSeg(-0.06177 vv 0.1935), LineSeg(-0.06546 vv 0.1926), LineSeg(-0.07048 vv 0.1924), LineSeg(-0.0763 vv 0.1939), LineSeg(-0.08231 vv 0.1969), LineSeg(-0.08454 vv 0.1974), LineSeg(-0.08949 vv 0.1969), LineSeg(-0.09101 vv 0.1967), LineSeg(-0.1001 vv 0.2016), LineSeg(-0.1119 vv 0.209), LineSeg(-0.1198 vv 0.2128), LineSeg(-0.1228 vv 0.2133), LineSeg(-0.1232 vv 0.2119), LineSeg(-0.1217 vv 0.2072), LineSeg(-0.1212 vv 0.2026), LineSeg(-0.1214 vv 0.1983), LineSeg(-0.1215 vv 0.1956), LineSeg(-0.1207 vv 0.1933), LineSeg(-0.1178 vv 0.1901), LineSeg(-0.1166 vv 0.1869), LineSeg(-0.1158 vv 0.1781), LineSeg(-0.1158 vv 0.1691), LineSeg(-0.1172 vv 0.1549), LineSeg(-0.1176 vv 0.1527), LineSeg(-0.1193 vv 0.1453), LineSeg(-0.1208 vv 0.1386), LineSeg(-0.1267 vv 0.1205), LineSeg(-0.1284 vv 0.1183), LineSeg(-0.1324 vv 0.1155), LineSeg(-0.1414 vv 0.1094), LineSeg(-0.148 vv 0.1056), LineSeg(-0.1501 vv 0.1047), LineSeg(-0.1555 vv 0.1043), LineSeg(-0.1589 vv 0.1045), LineSeg(-0.1631 vv 0.1067), LineSeg(-0.1672 vv 0.1078), LineSeg(-0.1726 vv 0.1117), LineSeg(-0.1786 vv 0.1129), LineSeg(-0.1851 vv 0.1167), LineSeg(-0.1869 vv 0.1187), LineSeg(-0.1904 vv 0.1191), LineSeg(-0.1954 vv 0.1206), LineSeg(-0.1954 vv 0.1206), LineSeg(-0.1972 vv 0.1211), LineSeg(-0.1985 vv 0.1215), LineSeg(-0.1985 vv 0.1215), LineSeg(-0.2048 vv 0.1217), LineSeg(-0.2107 vv 0.1244), LineSeg(-0.2138 vv 0.1251), LineSeg(-0.2181 vv 0.1254), LineSeg(-0.2225 vv 0.1233), LineSeg(-0.2225 vv 0.1233), LineSeg(-0.2247 vv 0.1222), LineSeg(-0.2276 vv 0.1234), LineSeg(-0.2297 vv 0.1232), LineSeg(-0.232 vv 0.1197), LineSeg(-0.2323 vv 0.1192), LineSeg(-0.2339 vv 0.1183), LineSeg(-0.2359 vv 0.1184), LineSeg(-0.2375 vv 0.1184), LineSeg(-0.2392 vv 0.1177), LineSeg(-0.2415 vv 0.1167), LineSeg(-0.2415 vv 0.1167), LineSeg(-0.2435 vv 0.1158), LineSeg(-0.2445 vv 0.1154), LineSeg(-0.2445 vv 0.1154), LineSeg(-0.2451 vv 0.1153), LineSeg(-0.2462 vv 0.1151), LineSeg(-0.2475 vv 0.1148), LineSeg(-0.2498 vv 0.1162), LineSeg(-0.2511 vv 0.1169), LineSeg(-0.2532 vv 0.1174), LineSeg(-0.2543 vv 0.1165), LineSeg(-0.2545 vv 0.1127), LineSeg(-0.2556 vv 0.1104), LineSeg(-0.2588 vv 0.1075), LineSeg(-0.2622 vv 0.1046), LineSeg(-0.2645 vv 0.1012), LineSeg(-0.2706 vv 0.0872), LineSeg(-0.2744 vv 0.08156), LineSeg(-0.2756 vv 0.08024), LineSeg(-0.2796 vv 0.07581), LineSeg(-0.2832 vv 0.07305), LineSeg(-0.2914 vv 0.06669), LineSeg(-0.2992 vv 0.06379), LineSeg(-0.3059 vv 0.06243), LineSeg(-0.3091 vv 0.06241), LineSeg(-0.3153 vv 0.06323), LineSeg(-0.3208 vv 0.06493), LineSeg(-0.3269 vv 0.06874), LineSeg(-0.3336 vv 0.0741), LineSeg(-0.3432 vv 0.08364), LineSeg(-0.3446 vv 0.08446), LineSeg(-0.3449 vv 0.08465), LineSeg(-0.3479 vv 0.08659), LineSeg(-0.3502 vv 0.08654), LineSeg(-0.3511 vv 0.08508), LineSeg(-0.3515 vv 0.08297), LineSeg(-0.352 vv 0.08111), LineSeg(-0.3531 vv 0.0705), LineSeg(-0.353 vv 0.06988), LineSeg(-0.3524 vv 0.06551), LineSeg(-0.3451 vv 0.05526), LineSeg(-0.3428 vv 0.04982), LineSeg(-0.3424 vv 0.04919), LineSeg(-0.3409 vv 0.04665), LineSeg(-0.3398 vv 0.04471), LineSeg(-0.3396 vv 0.04452), LineSeg(-0.3371 vv 0.03704), LineSeg(-0.3389 vv 0.03281), LineSeg(-0.338 vv 0.02999), LineSeg(-0.3402 vv 0.02826), LineSeg(-0.3406 vv 0.02582), LineSeg(-0.3341 vv 0.01756), LineSeg(-0.3326 vv 0.01392), LineSeg(-0.3342 vv 0.008871), LineSeg(-0.3368 vv 0.006086), LineSeg(-0.3375 vv 0.005324), LineSeg(-0.3371 vv 0.003191), LineSeg(-0.3341 vv 0.0004657), LineSeg(-0.329 vv -0.004118), LineSeg(-0.3262 vv -0.01093), LineSeg(-0.3241 vv -0.01275), LineSeg(-0.3217 vv -0.01224), LineSeg(-0.3204 vv -0.01327), LineSeg(-0.3183 vv -0.01323), LineSeg(-0.3163 vv -0.01525), LineSeg(-0.315 vv -0.01588), LineSeg(-0.3129 vv -0.0169), LineSeg(-0.3113 vv -0.01902), LineSeg(-0.3109 vv -0.02554), LineSeg(-0.3079 vv -0.03364), LineSeg(-0.3079 vv -0.03803), LineSeg(-0.3078 vv -0.03866), LineSeg(-0.306 vv -0.0419), LineSeg(-0.3054 vv -0.04447), LineSeg(-0.3064 vv -0.05125), LineSeg(-0.304 vv -0.05343), LineSeg(-0.3013 vv -0.05289), LineSeg(-0.2997 vv -0.05316), LineSeg(-0.2969 vv -0.05542), LineSeg(-0.2937 vv -0.06042), LineSeg(-0.2905 vv -0.05995), LineSeg(-0.2884 vv -0.06093), LineSeg(-0.2786 vv -0.06982), LineSeg(-0.2764 vv -0.07095), LineSeg(-0.2762 vv -0.07102), LineSeg(-0.2746 vv -0.07182), LineSeg(-0.2726 vv -0.07383), LineSeg(-0.2695 vv -0.07178), LineSeg(-0.2692 vv -0.07175), LineSeg(-0.2658 vv -0.07145), LineSeg(-0.2644 vv -0.07244), LineSeg(-0.2615 vv -0.07436), LineSeg(-0.2578 vv -0.07431), LineSeg(-0.2497 vv -0.07679), LineSeg(-0.2462 vv -0.07769), LineSeg(-0.2391 vv -0.0821), LineSeg(-0.2361 vv -0.08397), LineSeg(-0.2343 vv -0.08542), LineSeg(-0.2319 vv -0.08736), LineSeg(-0.2272 vv -0.0894), LineSeg(-0.2231 vv -0.09037), LineSeg(-0.2209 vv -0.09089), LineSeg(-0.2192 vv -0.09153), LineSeg(-0.2192 vv -0.09143), LineSeg(-0.2192 vv -0.09144), LineSeg(-0.2192 vv -0.09154), LineSeg(-0.2104 vv -0.09491), LineSeg(-0.2056 vv -0.09603), LineSeg(-0.2012 vv -0.09765), LineSeg(-0.198 vv -0.09882), LineSeg(-0.1957 vv -0.09886), LineSeg(-0.1923 vv -0.09606), LineSeg(-0.1891 vv -0.09587), LineSeg(-0.1864 vv -0.09654), LineSeg(-0.1838 vv -0.0961), LineSeg(-0.1796 vv -0.09355), LineSeg(-0.1788 vv -0.09235), LineSeg(-0.1759 vv -0.09095), LineSeg(-0.166 vv -0.08972), LineSeg(-0.1631 vv -0.09066), LineSeg(-0.1557 vv -0.08743), LineSeg(-0.1507 vv -0.08882), LineSeg(-0.1463 vv -0.08725), LineSeg(-0.1366 vv -0.08939), LineSeg(-0.1341 vv -0.09119), LineSeg(-0.1312 vv -0.09447), LineSeg(-0.1309 vv -0.09448), LineSeg(-0.1277 vv -0.09455), LineSeg(-0.129 vv -0.09676), LineSeg(-0.1248 vv -0.1012), LineSeg(-0.121 vv -0.1069), LineSeg(-0.1208 vv -0.1077), LineSeg(-0.118 vv -0.1158), LineSeg(-0.1159 vv -0.1187), LineSeg(-0.1145 vv -0.1227), LineSeg(-0.1144 vv -0.1253), LineSeg(-0.1167 vv -0.127), LineSeg(-0.117 vv -0.128), LineSeg(-0.1172 vv -0.1283), LineSeg(-0.1167 vv -0.1294), LineSeg(-0.1159 vv -0.1289), LineSeg(-0.1143 vv -0.1281), LineSeg(-0.1123 vv -0.1278), LineSeg(-0.1089 vv -0.1281), LineSeg(-0.1066 vv -0.1284), LineSeg(-0.103 vv -0.1266), LineSeg(-0.1006 vv -0.1254), LineSeg(-0.09682 vv -0.127), LineSeg(-0.09262 vv -0.127), LineSeg(-0.09085 vv -0.1278), LineSeg(-0.08586 vv -0.13), LineSeg(-0.08331 vv -0.1303), LineSeg(-0.08237 vv -0.1297), LineSeg(-0.08177 vv -0.1282), LineSeg(-0.08208 vv -0.1266), LineSeg(-0.08399 vv -0.1244), LineSeg(-0.08821 vv -0.1195), LineSeg(-0.08993 vv -0.117), LineSeg(-0.09125 vv -0.1133), LineSeg(-0.09166 vv -0.1087), LineSeg(-0.09195 vv -0.1055), LineSeg(-0.09142 vv -0.1014), LineSeg(-0.09029 vv -0.09991), LineSeg(-0.08946 vv -0.09663), LineSeg(-0.08946 vv -0.09665), LineSeg(-0.08924 vv -0.09579), LineSeg(-0.0869 vv -0.09268), LineSeg(-0.08069 vv -0.08869), LineSeg(-0.07402 vv -0.08272), LineSeg(-0.06875 vv -0.07925), LineSeg(-0.06332 vv -0.07689), LineSeg(-0.06318 vv -0.07623), LineSeg(-0.06257 vv -0.07648), LineSeg(-0.04875 vv -0.07178), LineSeg(-0.04852 vv -0.07175), LineSeg(-0.04237 vv -0.07068), LineSeg(-0.0008352 vv -0.0736), LineSeg(0.0007048 vv -0.07314), LineSeg(0.0007115 vv -0.07313), LineSeg(0.002095 vv -0.06925), LineSeg(0.00284 vv -0.06853), LineSeg(0.003335 vv -0.06806), LineSeg(0.007901 vv -0.06605), LineSeg(0.01004 vv -0.06574), LineSeg(0.01596 vv -0.0672), LineSeg(0.01839 vv -0.0678), LineSeg(0.02228 vv -0.06562), LineSeg(0.02503 vv -0.06567), LineSeg(0.03073 vv -0.06256), LineSeg(0.03425 vv -0.06265), LineSeg(0.03558 vv -0.06211), LineSeg(0.04244 vv -0.05719), LineSeg(0.04904 vv -0.0553), LineSeg(0.05076 vv -0.05438), LineSeg(0.05136 vv -0.05405), LineSeg(0.05813 vv -0.05048), LineSeg(0.06243 vv -0.04718), LineSeg(0.06614 vv -0.04521), LineSeg(0.0702 vv -0.04416), LineSeg(0.08083 vv -0.04341), LineSeg(0.08297 vv -0.03985), LineSeg(0.08754 vv -0.03924), LineSeg(0.09031 vv -0.03612), LineSeg(0.09347 vv -0.03483), LineSeg(0.09573 vv -0.03157), LineSeg(0.09763 vv -0.02884), LineSeg(0.1003 vv -0.0273), LineSeg(0.1088 vv -0.02677), LineSeg(0.1189 vv -0.02802), LineSeg(0.1202 vv -0.02721), LineSeg(0.1225 vv -0.01908), LineSeg(0.1248 vv -0.01756), LineSeg(0.1313 vv -0.008204), LineSeg(0.1313 vv -0.004796), LineSeg(0.1313 vv -0.001949), LineSeg(0.1323 vv 0.002104), LineSeg(0.1316 vv 0.009422), LineSeg(0.1325 vv 0.01683), LineSeg(0.1365 vv 0.02625), LineSeg(0.14 vv 0.03005), LineSeg(0.1457 vv 0.03388), LineSeg(0.1485 vv 0.03514), LineSeg(0.1526 vv 0.03582), LineSeg(0.1526 vv 0.03582), LineSeg(0.1532 vv 0.03593), LineSeg(0.1542 vv 0.0361), LineSeg(0.1683 vv 0.0363), BezierSeg(0.1685 vv 0.03644, 0.1734 vv 0.03637, 0.1734 vv 0.03637), LineSeg(0.1781 vv 0.03643), LineSeg(0.19 vv 0.03432), LineSeg(0.1908 vv 0.03417), LineSeg(0.1948 vv 0.03288), LineSeg(0.1994 vv 0.02928), LineSeg(0.2043 vv 0.0245), LineSeg(0.2052 vv 0.02361), LineSeg(0.2084 vv 0.02227), LineSeg(0.2094 vv 0.02186), LineSeg(0.212 vv 0.02227), LineSeg(0.2157 vv 0.02422), LineSeg(0.2185 vv 0.02659), LineSeg(0.2224 vv 0.02869), LineSeg(0.2225 vv 0.02882), LineSeg(0.2246 vv 0.03207), LineSeg(0.2247 vv 0.03214), LineSeg(0.2247 vv 0.03212), LineSeg(0.2247 vv 0.03214), LineSeg(0.2247 vv 0.03215), LineSeg(0.2256 vv 0.03344), LineSeg(0.233 vv 0.03633), LineSeg(0.2417 vv 0.03684), LineSeg(0.2427 vv 0.03737), LineSeg(0.2432 vv 0.03766), LineSeg(0.2455 vv 0.04036), LineSeg(0.2477 vv 0.04038), LineSeg(0.2529 vv 0.03849), LineSeg(0.2566 vv 0.03922), LineSeg(0.2595 vv 0.03806), LineSeg(0.2617 vv 0.03832), LineSeg(0.266 vv 0.03883), LineSeg(0.2706 vv 0.0356), LineSeg(0.2733 vv 0.03526), LineSeg(0.2827 vv 0.02974), LineSeg(0.2832 vv 0.02966), LineSeg(0.2835 vv 0.02962), LineSeg(0.284 vv 0.02953), LineSeg(0.2851 vv 0.02986), LineSeg(0.2868 vv 0.03034), LineSeg(0.287 vv 0.03041), LineSeg(0.2872 vv 0.03012), LineSeg(0.2883 vv 0.0286), LineSeg(0.2898 vv 0.02839), LineSeg(0.2915 vv 0.03072), LineSeg(0.2908 vv 0.03177), LineSeg(0.2905 vv 0.03215), LineSeg(0.2872 vv 0.03284), LineSeg(0.2841 vv 0.03801), LineSeg(0.287 vv 0.04111), LineSeg(0.2825 vv 0.04665), LineSeg(0.2818 vv 0.04757), LineSeg(0.2815 vv 0.04796), LineSeg(0.2799 vv 0.05033), LineSeg(0.272 vv 0.06239), LineSeg(0.2617 vv 0.07062), LineSeg(0.2617 vv 0.07061), LineSeg(0.2581 vv 0.0735), LineSeg(0.2581 vv 0.07351), LineSeg(0.2568 vv 0.07451), LineSeg(0.2513 vv 0.0801), LineSeg(0.2474 vv 0.08532), LineSeg(0.2469 vv 0.08644), LineSeg(0.2461 vv 0.08821), LineSeg(0.2437 vv 0.09334), LineSeg(0.2396 vv 0.0965), LineSeg(0.2363 vv 0.1002), LineSeg(0.2361 vv 0.1004), LineSeg(0.2292 vv 0.1097), LineSeg(0.2281 vv 0.1113), LineSeg(0.2264 vv 0.1123), LineSeg(0.223 vv 0.1123), LineSeg(0.2227 vv 0.1126), LineSeg(0.2225 vv 0.1128), LineSeg(0.2226 vv 0.1129), LineSeg(0.2243 vv 0.1146), LineSeg(0.2261 vv 0.115), LineSeg(0.2269 vv 0.1169), LineSeg(0.2234 vv 0.127), LineSeg(0.2233 vv 0.1274), LineSeg(0.2231 vv 0.1306), LineSeg(0.226 vv 0.1454), LineSeg(0.2263 vv 0.1472), LineSeg(0.2312 vv 0.1571), LineSeg(0.2342 vv 0.1596), LineSeg(0.2375 vv 0.1661), LineSeg(0.2403 vv 0.1702), LineSeg(0.2431 vv 0.1729), LineSeg(0.2435 vv 0.1731), LineSeg(0.2484 vv 0.1761), LineSeg(0.2525 vv 0.1767), LineSeg(0.2564 vv 0.1772), LineSeg(0.2633 vv 0.1751), LineSeg(0.2698 vv 0.1753), LineSeg(0.271 vv 0.1754), LineSeg(0.274 vv 0.1757), LineSeg(0.2788 vv 0.1773), LineSeg(0.2811 vv 0.1787), LineSeg(0.2823 vv 0.1805), LineSeg(0.2848 vv 0.1888), LineSeg(0.2856 vv 0.1915), LineSeg(0.2871 vv 0.1943), LineSeg(0.296 vv 0.2045), LineSeg(0.3027 vv 0.2107), LineSeg(0.3177 vv 0.2217), LineSeg(0.325 vv 0.2261), LineSeg(0.3288 vv 0.2284), LineSeg(0.3623 vv 0.2433), LineSeg(0.3711 vv 0.2521), LineSeg(0.3756 vv 0.2567), LineSeg(0.3836 vv 0.2621), LineSeg(0.393 vv 0.2659), LineSeg(0.4011 vv 0.2723), LineSeg(0.4029 vv 0.2746), LineSeg(0.4051 vv 0.2817), LineSeg(0.407 vv 0.2822), LineSeg(0.4087 vv 0.2858), LineSeg(0.4091 vv 0.2868), LineSeg(0.4157 vv 0.2915), LineSeg(0.4165 vv 0.2919), LineSeg(0.4421 vv 0.3047), LineSeg(0.4459 vv 0.3042), LineSeg(0.4478 vv 0.3072), LineSeg(0.4553 vv 0.3084), LineSeg(0.4567 vv 0.3087), LineSeg(0.4585 vv 0.3096), LineSeg(0.4601 vv 0.3123), LineSeg(0.4596 vv 0.3123), LineSeg(0.4598 vv 0.3194), LineSeg(0.4614 vv 0.3213), LineSeg(0.4622 vv 0.326), LineSeg(0.4631 vv 0.3271), LineSeg(0.4639 vv 0.3282), LineSeg(0.466 vv 0.3297), LineSeg(0.4657 vv 0.3306), LineSeg(0.4619 vv 0.3267)).fill(Colour(0xFFd57800))

    val leaf01 =  PolyCurve(LineSeg(0.02184 vv -0.3446), BezierSeg(0.02154 vv -0.3444, 0.02147 vv -0.3444, 0.02126 vv -0.3442), LineSeg(0.02105 vv -0.344), BezierSeg(0.02051 vv -0.3435, 0.01961 vv -0.3426, 0.01841 vv -0.3412), BezierSeg(0.01619 vv -0.3387, 0.01321 vv -0.335, 0.0106 vv -0.3318), BezierSeg(0.005405 vv -0.3253, 0.001115 vv -0.3197, 0.0003065 vv -0.3187), LineSeg(-0.001015 vv -0.3169), LineSeg(-0.01396 vv -0.3129), LineSeg(-0.02341 vv -0.3085), LineSeg(-0.01836 vv -0.3029), LineSeg(-0.001015 vv -0.3103), LineSeg(0.01193 vv -0.3129), LineSeg(0.03587 vv -0.3305), LineSeg(0.03585 vv -0.3306), BezierSeg(0.0358 vv -0.3306, 0.03237 vv -0.3335, 0.02896 vv -0.3366), BezierSeg(0.02743 vv -0.3379, 0.02552 vv -0.3397, 0.02416 vv -0.3412), BezierSeg(0.02354 vv -0.3419, 0.02299 vv -0.3426, 0.02261 vv -0.3431), BezierSeg(0.02238 vv -0.3434, 0.02225 vv -0.3437, 0.02219 vv -0.3439), LineSeg(0.02368 vv -0.343), LineSeg(0.02529 vv -0.3442), LineSeg(0.02201 vv -0.3445), LineSeg(0.02186 vv -0.3446), LineSeg(0.02184 vv -0.3446)).fill(Colour(0xFF4e5b31))
    val leaf02 =  PolyCurve(LineSeg(-0.06704 vv -0.3179), BezierSeg(-0.07834 vv -0.3179, -0.08949 vv -0.3147, -0.1002 vv -0.3086), LineSeg(-0.1002 vv -0.3086), LineSeg(-0.1002 vv -0.3086), BezierSeg(-0.1002 vv -0.3086, -0.09881 vv -0.3059, -0.09541 vv -0.3034), BezierSeg(-0.09217 vv -0.301, -0.08634 vv -0.2982, -0.07691 vv -0.2981), LineSeg(-0.07691 vv -0.2983), BezierSeg(-0.06574 vv -0.2983, -0.05207 vv -0.3021, -0.03629 vv -0.3096), BezierSeg(-0.03682 vv -0.31, -0.04921 vv -0.318, -0.06723 vv -0.318), LineSeg(-0.06721 vv -0.3181), LineSeg(-0.06704 vv -0.3179)).fill(Colour(0xFF4e5b31))
    val leaf03 =  PolyCurve(LineSeg(-0.1162 vv -0.3072), BezierSeg(-0.1183 vv -0.3072, -0.1201 vv -0.3064, -0.1214 vv -0.305), BezierSeg(-0.1225 vv -0.3038, -0.1233 vv -0.3023, -0.1238 vv -0.3002), BezierSeg(-0.1247 vv -0.2968, -0.1244 vv -0.2935, -0.1244 vv -0.2932), BezierSeg(-0.1235 vv -0.2928, -0.1226 vv -0.2926, -0.1218 vv -0.2926), LineSeg(-0.1216 vv -0.2926), BezierSeg(-0.1174 vv -0.2926, -0.1141 vv -0.2962, -0.1127 vv -0.2998), BezierSeg(-0.1119 vv -0.3018, -0.1118 vv -0.3036, -0.1123 vv -0.3049), BezierSeg(-0.1128 vv -0.3063, -0.1143 vv -0.3072, -0.1162 vv -0.3072), LineSeg(-0.1162 vv -0.3072)).fill(Colour(0xFF4e5b31))
    val leaf04 =  PolyCurve(LineSeg(-0.03003 vv -0.2972), BezierSeg(-0.05896 vv -0.2931, -0.07122 vv -0.2826, -0.07641 vv -0.2746), BezierSeg(-0.08195 vv -0.266, -0.08082 vv -0.2581, -0.0808 vv -0.258), LineSeg(-0.0808 vv -0.258), LineSeg(-0.08078 vv -0.2579), BezierSeg(-0.08077 vv -0.2579, -0.07901 vv -0.2575, -0.07635 vv -0.2575), BezierSeg(-0.06865 vv -0.2575, -0.04896 vv -0.2613, -0.03002 vv -0.2972), LineSeg(-0.03001 vv -0.2972), LineSeg(-0.03004 vv -0.2972), LineSeg(-0.03003 vv -0.2972)).fill(Colour(0xFF4e5b31))
    val leaf05 =  PolyCurve(LineSeg(-0.08934 vv -0.2915), BezierSeg(-0.1017 vv -0.2915, -0.1111 vv -0.2893, -0.1173 vv -0.2851), BezierSeg(-0.1209 vv -0.2827, -0.1226 vv -0.2801, -0.1235 vv -0.2783), BezierSeg(-0.1242 vv -0.2766, -0.1244 vv -0.2752, -0.1244 vv -0.2749), BezierSeg(-0.1241 vv -0.2747, -0.1191 vv -0.2725, -0.1115 vv -0.2721), BezierSeg(-0.1109 vv -0.2721, -0.1102 vv -0.2721, -0.1095 vv -0.2721), BezierSeg(-0.09999 vv -0.2721, -0.08546 vv -0.2752, -0.07013 vv -0.29), LineSeg(-0.07012 vv -0.2901), LineSeg(-0.07014 vv -0.2901), BezierSeg(-0.07714 vv -0.291, -0.0836 vv -0.2915, -0.08935 vv -0.2915), LineSeg(-0.08934 vv -0.2915)).fill(Colour(0xFF4e5b31))
    val leaf06 =  PolyCurve(LineSeg(-0.1492 vv -0.2892), BezierSeg(-0.1622 vv -0.2892, -0.1801 vv -0.2852, -0.1913 vv -0.274), LineSeg(-0.1913 vv -0.274), LineSeg(-0.1913 vv -0.274), BezierSeg(-0.1912 vv -0.274, -0.1791 vv -0.2709, -0.1654 vv -0.2706), BezierSeg(-0.1646 vv -0.2705, -0.1638 vv -0.2705, -0.163 vv -0.2705), BezierSeg(-0.1507 vv -0.2705, -0.1414 vv -0.2729, -0.1352 vv -0.2776), BezierSeg(-0.133 vv -0.2792, -0.1318 vv -0.2807, -0.1315 vv -0.2822), BezierSeg(-0.1313 vv -0.2835, -0.132 vv -0.2848, -0.1333 vv -0.2858), BezierSeg(-0.1361 vv -0.2879, -0.1411 vv -0.289, -0.1482 vv -0.2892), LineSeg(-0.1492 vv -0.2892), LineSeg(-0.1492 vv -0.2892)).fill(Colour(0xFF4e5b31))
    val leaf07 =  PolyCurve(LineSeg(-0.1914 vv -0.2675), BezierSeg(-0.193 vv -0.2675, -0.1945 vv -0.2668, -0.1956 vv -0.2656), BezierSeg(-0.1964 vv -0.2646, -0.197 vv -0.2632, -0.1974 vv -0.2614), BezierSeg(-0.1981 vv -0.2583, -0.1979 vv -0.2553, -0.1979 vv -0.2553), LineSeg(-0.1979 vv -0.2552), BezierSeg(-0.1973 vv -0.2549, -0.1966 vv -0.2548, -0.1959 vv -0.2548), LineSeg(-0.1959 vv -0.2548), BezierSeg(-0.1939 vv -0.2548, -0.1925 vv -0.2558, -0.1915 vv -0.2567), BezierSeg(-0.1903 vv -0.2579, -0.1893 vv -0.2594, -0.1887 vv -0.2611), BezierSeg(-0.1881 vv -0.2628, -0.188 vv -0.2643, -0.1884 vv -0.2655), BezierSeg(-0.1888 vv -0.2665, -0.1899 vv -0.2675, -0.1914 vv -0.2675), LineSeg(-0.1914 vv -0.2675)).fill(Colour(0xFF4e5b31))
    val leaf08 =  PolyCurve(LineSeg(-0.09388 vv -0.2653), BezierSeg(-0.09597 vv -0.2653, -0.09785 vv -0.2645, -0.09916 vv -0.2631), BezierSeg(-0.1002 vv -0.2619, -0.101 vv -0.2603, -0.1015 vv -0.2583), BezierSeg(-0.1024 vv -0.2549, -0.1021 vv -0.2516, -0.1021 vv -0.2513), BezierSeg(-0.1012 vv -0.2509, -0.1003 vv -0.2507, -0.09952 vv -0.2507), LineSeg(-0.09933 vv -0.2507), BezierSeg(-0.09514 vv -0.2507, -0.09185 vv -0.2543, -0.09043 vv -0.2579), BezierSeg(-0.08963 vv -0.2599, -0.08948 vv -0.2617, -0.08998 vv -0.263), BezierSeg(-0.09048 vv -0.2644, -0.09206 vv -0.2653, -0.09388 vv -0.2653), LineSeg(-0.09388 vv -0.2653)).fill(Colour(0xFF4e5b31))
    val leaf09 =  PolyCurve(LineSeg(-0.1414 vv -0.2633), BezierSeg(-0.1676 vv -0.2624, -0.1812 vv -0.255, -0.188 vv -0.2489), BezierSeg(-0.1919 vv -0.2454, -0.194 vv -0.242, -0.1951 vv -0.2398), BezierSeg(-0.1961 vv -0.2377, -0.1965 vv -0.236, -0.1966 vv -0.2357), LineSeg(-0.1966 vv -0.2357), BezierSeg(-0.1966 vv -0.2357, -0.1941 vv -0.2348, -0.1901 vv -0.2347), LineSeg(-0.1895 vv -0.2347), BezierSeg(-0.1806 vv -0.2347, -0.1626 vv -0.2384, -0.1414 vv -0.2633), LineSeg(-0.1414 vv -0.2633), LineSeg(-0.1414 vv -0.2633)).fill(Colour(0xFF4e5b31))
    val leaf10 =  PolyCurve(LineSeg(-0.1129 vv -0.2607), BezierSeg(-0.134 vv -0.2575, -0.146 vv -0.2484, -0.1523 vv -0.2414), BezierSeg(-0.1589 vv -0.234, -0.1609 vv -0.2271, -0.161 vv -0.2268), BezierSeg(-0.1609 vv -0.2268, -0.1583 vv -0.2261, -0.1545 vv -0.226), BezierSeg(-0.1542 vv -0.226, -0.1539 vv -0.226, -0.1536 vv -0.226), BezierSeg(-0.1533 vv -0.226, -0.153 vv -0.226, -0.1527 vv -0.226), BezierSeg(-0.1421 vv -0.2262, -0.1228 vv -0.2311, -0.1129 vv -0.2607), LineSeg(-0.1129 vv -0.2607), LineSeg(-0.1129 vv -0.2607)).fill(Colour(0xFF4e5b31))
    val leaf11 =  PolyCurve(LineSeg(-0.2212 vv -0.2505), BezierSeg(-0.2282 vv -0.2505, -0.2349 vv -0.2497, -0.2412 vv -0.2482), BezierSeg(-0.2522 vv -0.2454, -0.257 vv -0.2412, -0.259 vv -0.2381), BezierSeg(-0.2601 vv -0.2364, -0.2606 vv -0.2349, -0.2607 vv -0.2339), BezierSeg(-0.2609 vv -0.233, -0.2608 vv -0.2322, -0.2608 vv -0.2321), LineSeg(-0.2607 vv -0.2321), BezierSeg(-0.2607 vv -0.2321, -0.2534 vv -0.23, -0.2433 vv -0.2299), BezierSeg(-0.2429 vv -0.2299, -0.2425 vv -0.2299, -0.2421 vv -0.2299), BezierSeg(-0.2372 vv -0.2299, -0.2324 vv -0.2303, -0.2278 vv -0.2313), BezierSeg(-0.2102 vv -0.2348, -0.2011 vv -0.248, -0.201 vv -0.2482), LineSeg(-0.201 vv -0.2482), LineSeg(-0.2011 vv -0.2482), BezierSeg(-0.2012 vv -0.2482, -0.2095 vv -0.2505, -0.2213 vv -0.2505), LineSeg(-0.2212 vv -0.2505)).fill(Colour(0xFF4e5b31))
    val leaf12 =  PolyCurve(LineSeg(-0.1723 vv -0.2327), BezierSeg(-0.1744 vv -0.2327, -0.1763 vv -0.232, -0.1776 vv -0.2306), BezierSeg(-0.1786 vv -0.2294, -0.1794 vv -0.2278, -0.1799 vv -0.2257), BezierSeg(-0.1808 vv -0.2224, -0.1805 vv -0.2191, -0.1805 vv -0.2187), BezierSeg(-0.1796 vv -0.2184, -0.1787 vv -0.2182, -0.1779 vv -0.2182), LineSeg(-0.1777 vv -0.2182), BezierSeg(-0.1735 vv -0.2182, -0.1702 vv -0.2218, -0.1688 vv -0.2254), BezierSeg(-0.168 vv -0.2274, -0.1679 vv -0.2291, -0.1684 vv -0.2304), BezierSeg(-0.1689 vv -0.2318, -0.1704 vv -0.2327, -0.1723 vv -0.2327), LineSeg(-0.1723 vv -0.2327)).fill(Colour(0xFF4e5b31))
    val leaf13 =  PolyCurve(LineSeg(-0.2091 vv -0.2277), BezierSeg(-0.2093 vv -0.2277, -0.2191 vv -0.2251, -0.229 vv -0.219), BezierSeg(-0.2383 vv -0.2133, -0.2496 vv -0.2032, -0.251 vv -0.1876), LineSeg(-0.251 vv -0.1876), LineSeg(-0.2509 vv -0.1876), BezierSeg(-0.2509 vv -0.1876, -0.2501 vv -0.1874, -0.2488 vv -0.1873), BezierSeg(-0.2486 vv -0.1873, -0.2485 vv -0.1873, -0.2483 vv -0.1873), BezierSeg(-0.2455 vv -0.1873, -0.2399 vv -0.1881, -0.233 vv -0.1933), BezierSeg(-0.2243 vv -0.1999, -0.2163 vv -0.2115, -0.2091 vv -0.2277), LineSeg(-0.2091 vv -0.2277)).fill(Colour(0xFF4e5b31))
    val leaf14 =  PolyCurve(LineSeg(-0.185 vv -0.2268), BezierSeg(-0.1851 vv -0.2268, -0.1921 vv -0.224, -0.2008 vv -0.2167), BezierSeg(-0.209 vv -0.2099, -0.2204 vv -0.1976, -0.2287 vv -0.1778), BezierSeg(-0.2287 vv -0.1778, -0.2268 vv -0.1768, -0.2239 vv -0.1766), BezierSeg(-0.2237 vv -0.1766, -0.2235 vv -0.1766, -0.2234 vv -0.1766), BezierSeg(-0.2231 vv -0.1766, -0.2229 vv -0.1766, -0.2226 vv -0.1766), BezierSeg(-0.2186 vv -0.1767, -0.2125 vv -0.1784, -0.2057 vv -0.1857), BezierSeg(-0.1979 vv -0.1941, -0.1909 vv -0.208, -0.185 vv -0.2268), LineSeg(-0.185 vv -0.2269), LineSeg(-0.185 vv -0.2268), LineSeg(-0.185 vv -0.2268)).fill(Colour(0xFF4e5b31))
    val leaf15 =  PolyCurve(LineSeg(-0.2474 vv -0.225), BezierSeg(-0.2554 vv -0.225, -0.2581 vv -0.2207, -0.2589 vv -0.2188), BezierSeg(-0.2603 vv -0.2157, -0.2599 vv -0.2126, -0.2599 vv -0.2126), LineSeg(-0.2599 vv -0.2126), BezierSeg(-0.2586 vv -0.2123, -0.2572 vv -0.2121, -0.2559 vv -0.2121), LineSeg(-0.2556 vv -0.2121), BezierSeg(-0.2493 vv -0.2121, -0.2443 vv -0.2153, -0.2421 vv -0.2185), BezierSeg(-0.2417 vv -0.2191, -0.2404 vv -0.2213, -0.2415 vv -0.223), BezierSeg(-0.2423 vv -0.2243, -0.2443 vv -0.225, -0.2474 vv -0.225), LineSeg(-0.2474 vv -0.225)).fill(Colour(0xFF4e5b31))
    val leaf16 =  PolyCurve(LineSeg(-0.2652 vv -0.2026), BezierSeg(-0.2696 vv -0.2026, -0.2765 vv -0.2023, -0.2837 vv -0.201), BezierSeg(-0.2909 vv -0.1997, -0.2949 vv -0.1936, -0.2971 vv -0.1887), BezierSeg(-0.2994 vv -0.1834, -0.3001 vv -0.1784, -0.3001 vv -0.1783), LineSeg(-0.3001 vv -0.1783), BezierSeg(-0.2779 vv -0.179, -0.2675 vv -0.1854, -0.2626 vv -0.1908), BezierSeg(-0.2576 vv -0.1962, -0.2573 vv -0.2019, -0.2573 vv -0.2023), LineSeg(-0.2573 vv -0.2023), BezierSeg(-0.2573 vv -0.2023, -0.2604 vv -0.2026, -0.2652 vv -0.2026), LineSeg(-0.2652 vv -0.2026)).fill(Colour(0xFF4e5b31))
    val leaf17 =  PolyCurve(LineSeg(-0.2421 vv -0.1796), BezierSeg(-0.2422 vv -0.1795, -0.2447 vv -0.1764, -0.2472 vv -0.1725), BezierSeg(-0.2498 vv -0.1684, -0.2522 vv -0.1642, -0.2522 vv -0.1607), BezierSeg(-0.2522 vv -0.1573, -0.253 vv -0.1503, -0.2535 vv -0.1463), BezierSeg(-0.2541 vv -0.1414, -0.2547 vv -0.1371, -0.2547 vv -0.1367), LineSeg(-0.2547 vv -0.1368), BezierSeg(-0.2542 vv -0.137, -0.2409 vv -0.1419, -0.2409 vv -0.1544), BezierSeg(-0.2409 vv -0.1669, -0.2421 vv -0.1794, -0.2421 vv -0.1796), LineSeg(-0.2421 vv -0.1796), LineSeg(-0.2421 vv -0.1796), LineSeg(-0.2421 vv -0.1796)).fill(Colour(0xFF4e5b31))
    val leaf18 =  PolyCurve(LineSeg(-0.2593 vv -0.1784), BezierSeg(-0.2595 vv -0.1784, -0.2596 vv -0.1784, -0.2598 vv -0.1783), BezierSeg(-0.2637 vv -0.1777, -0.2706 vv -0.1747, -0.2782 vv -0.1703), BezierSeg(-0.2867 vv -0.1654, -0.2936 vv -0.1602, -0.2976 vv -0.1557), BezierSeg(-0.3012 vv -0.1515, -0.3034 vv -0.1449, -0.304 vv -0.1361), BezierSeg(-0.3045 vv -0.1299, -0.304 vv -0.1247, -0.3039 vv -0.1242), BezierSeg(-0.3032 vv -0.1239, -0.3025 vv -0.1238, -0.3017 vv -0.1238), BezierSeg(-0.2988 vv -0.1239, -0.2956 vv -0.1252, -0.2914 vv -0.1281), BezierSeg(-0.2881 vv -0.1304, -0.2844 vv -0.1335, -0.2806 vv -0.1373), BezierSeg(-0.2739 vv -0.1439, -0.2686 vv -0.1505, -0.2686 vv -0.1506), LineSeg(-0.2685 vv -0.1507), BezierSeg(-0.2681 vv -0.1515, -0.2643 vv -0.1583, -0.2613 vv -0.1649), BezierSeg(-0.2595 vv -0.1691, -0.2584 vv -0.1722, -0.258 vv -0.1745), BezierSeg(-0.2577 vv -0.1758, -0.2577 vv -0.1767, -0.258 vv -0.1775), BezierSeg(-0.2581 vv -0.1778, -0.2584 vv -0.1781, -0.2586 vv -0.1782), BezierSeg(-0.2589 vv -0.1783, -0.2591 vv -0.1784, -0.2594 vv -0.1784), LineSeg(-0.2593 vv -0.1784)).fill(Colour(0xFF4e5b31))

    Arr[DisplayAffineElem](
      background,
      map,
      leaf01, leaf02, leaf03, leaf04, leaf05, leaf06, leaf07, leaf08, leaf09, leaf10, leaf11, leaf12, leaf13, leaf14, leaf15, leaf16, leaf17, leaf18,
      leaf01.negX, leaf02.negX, leaf03.negX, leaf04.negX, leaf05.negX, leaf06.negX, leaf07.negX, leaf08.negX, leaf09.negX, leaf10.negX,
      leaf11.negX, leaf12.negX, leaf13.negX, leaf14.negX, leaf15.negX, leaf16.negX, leaf17.negX, leaf18.negX
    )
  }
}
