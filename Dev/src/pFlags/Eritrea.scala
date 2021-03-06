/* Copyright 2018-20 Richard Oliver, w0d. Licensed under Apache Licence version 2.0. */
package ostrat
package pFlags
import geom._

object Eritrea extends Flag
{ val name = "Eritrea"
  val ratio = 2.0
  
  val apply: GraphicElems =
  { 
    val blueRectangle = Rect(2, 0.5, 0 vv 0.25).fillHex(0xFF4189dd)
    val greenRectangle = Rect(2, 0.5, 0 vv -0.25).fillHex(0xFF12ad2b)
    val redTriangle: TriangleFill = Triangle(-1 vv 0.5, -1 vv -0.5, 1 vv 0).fillHex(0xFFea0437)
    
    val olive = PolyCurve(LineTail(-0.5395 vv -0.2383), BezierTail(-0.5611 vv -0.2443, -0.5735 vv -0.2611, -0.5732 vv -0.2769),
      LineTail(-0.4668 vv -0.2765), BezierTail(-0.4658 vv -0.2595, -0.4798 vv -0.2437, -0.5011 vv -0.2375),
      BezierTail(-0.3969 vv -0.2354, -0.3064 vv -0.1964, -0.2899 vv -0.1713), BezierTail(-0.3062 vv -0.1642, -0.325 vv -0.1756, -0.3385 vv -0.173),
      BezierTail(-0.3066 vv -0.1583, -0.2112 vv -0.09651, -0.2267 vv -0.03028),
      BezierTail(-0.2387 vv -0.06707, -0.2753 vv -0.0975, -0.2908 vv -0.1057),
      BezierTail(-0.2552 vv -0.05154, -0.2065 vv 0.004824, -0.2488 vv 0.04847),
      BezierTail(-0.2466 vv 0.02317, -0.2648 vv -0.004666, -0.2729 vv -0.006758),
      BezierTail(-0.2522 vv 0.05044, -0.2325 vv 0.1223, -0.2773 vv 0.1696), BezierTail(-0.2714 vv 0.1525, -0.2738 vv 0.1042, -0.2819 vv 0.102),
      BezierTail(-0.2843 vv 0.1409, -0.291 vv 0.2228, -0.3319 vv 0.2216), BezierTail(-0.3189 vv 0.21, -0.3132 vv 0.1784, -0.313 vv 0.1465),
      BezierTail(-0.3223 vv 0.1683, -0.3329 vv 0.1848, -0.3556 vv 0.201), BezierTail(-0.3739 vv 0.2362, -0.4066 vv 0.2653, -0.4393 vv 0.2862),
      BezierTail(-0.4356 vv 0.2606, -0.4326 vv 0.2404, -0.3968 vv 0.2138), BezierTail(-0.4154 vv 0.215, -0.4341 vv 0.2503, -0.454 vv 0.2513),
      BezierTail(-0.4699 vv 0.2521, -0.4823 vv 0.2369, -0.5082 vv 0.2457), BezierTail(-0.5054 vv 0.2371, -0.4933 vv 0.2333, -0.4907 vv 0.227),
      BezierTail(-0.4963 vv 0.2232, -0.5095 vv 0.2276, -0.5204 vv 0.2333), BezierTail(-0.5054 vv 0.2128, -0.482 vv 0.2007, -0.4622 vv 0.2048),
      BezierTail(-0.4386 vv 0.2093, -0.4133 vv 0.2069, -0.3892 vv 0.1932), BezierTail(-0.3954 vv 0.19, -0.4193 vv 0.19, -0.4347 vv 0.192),
      BezierTail(-0.4207 vv 0.1778, -0.4114 vv 0.1684, -0.3871 vv 0.1686), BezierTail(-0.3654 vv 0.1687, -0.354 vv 0.1802, -0.3484 vv 0.1731),
      BezierTail(-0.3348 vv 0.157, -0.3256 vv 0.1408, -0.3142 vv 0.1218), BezierTail(-0.3394 vv 0.1191, -0.3318 vv 0.1503, -0.3598 vv 0.1663),
      BezierTail(-0.3756 vv 0.1337, -0.3417 vv 0.09505, -0.3187 vv 0.07899), BezierTail(-0.3184 vv 0.05449, -0.3148 vv 0.034, -0.3044 vv 0.01535),
      BezierTail(-0.2974 vv 0.002203, -0.2883 vv -0.01125, -0.2917 vv -0.04093),
      BezierTail(-0.3055 vv -0.03088, -0.319 vv 0.003005, -0.3141 vv 0.0299),
      BezierTail(-0.3313 vv 0.02519, -0.3381 vv -0.005166, -0.3299 vv -0.02045),
      BezierTail(-0.3239 vv -0.03209, -0.3198 vv -0.05435, -0.3268 vv -0.06431),
      BezierTail(-0.3336 vv -0.07358, -0.3344 vv -0.07254, -0.3343 vv -0.09245),
      BezierTail(-0.334 vv -0.1044, -0.3407 vv -0.1184, -0.3515 vv -0.1283), BezierTail(-0.3493 vv -0.1199, -0.3467 vv -0.1054, -0.3492 vv -0.09641),
      BezierTail(-0.3578 vv -0.1109, -0.3792 vv -0.126, -0.386 vv -0.1416), BezierTail(-0.3927 vv -0.1573, -0.3943 vv -0.1844, -0.4265 vv -0.1906),
      BezierTail(-0.4679 vv -0.1988, -0.4822 vv -0.206, -0.5088 vv -0.2169), BezierTail(-0.5117 vv -0.1967, -0.5029 vv -0.1545, -0.486 vv -0.1569),
      BezierTail(-0.4695 vv -0.1599, -0.4194 vv -0.1397, -0.4373 vv -0.09751), BezierTail(-0.4409 vv -0.1108, -0.4527 vv -0.1238, -0.4654 vv -0.1243),
      BezierTail(-0.4516 vv -0.1065, -0.427 vv -0.08796, -0.439 vv -0.058), BezierTail(-0.4457 vv -0.07074, -0.4561 vv -0.08602, -0.472 vv -0.09461),
      BezierTail(-0.455 vv -0.06199, -0.47 vv -0.05224, -0.4903 vv -0.0791), BezierTail(-0.4979 vv -0.08947, -0.5025 vv -0.1102, -0.5073 vv -0.1366),
      BezierTail(-0.5153 vv -0.1152, -0.5148 vv -0.08692, -0.5242 vv -0.06399),
      BezierTail(-0.534 vv -0.03919, -0.5111 vv -0.03264, -0.5004 vv -0.03463),
      BezierTail(-0.474 vv -0.04167, -0.43 vv -0.04166, -0.4332 vv 0.001873), BezierTail(-0.4446 vv -0.01285, -0.4646 vv -0.0174, -0.4861 vv -0.0121),
      BezierTail(-0.4619 vv 0.005577, -0.4428 vv 0.03883, -0.4698 vv 0.05619), BezierTail(-0.4707 vv 0.03778, -0.4849 vv 0.01714, -0.504 vv 0.007632),
      BezierTail(-0.5084 vv 0.02316, -0.5084 vv 0.03965, -0.5046 vv 0.05772), BezierTail(-0.5152 vv 0.04654, -0.523 vv 0.02328, -0.5291 vv -0.00316),
      BezierTail(-0.5296 vv 0.02298, -0.5247 vv 0.04181, -0.521 vv 0.05587), BezierTail(-0.5154 vv 0.07641, -0.5016 vv 0.06304, -0.4805 vv 0.06153),
      BezierTail(-0.4601 vv 0.06037, -0.4321 vv 0.07163, -0.4374 vv 0.09925), BezierTail(-0.4444 vv 0.08832, -0.4587 vv 0.08407, -0.4732 vv 0.08523),
      BezierTail(-0.4557 vv 0.09586, -0.4251 vv 0.1148, -0.4419 vv 0.1438), BezierTail(-0.4489 vv 0.1328, -0.4512 vv 0.1234, -0.4716 vv 0.12),
      BezierTail(-0.4662 vv 0.1323, -0.4654 vv 0.1497, -0.4495 vv 0.1566), BezierTail(-0.4778 vv 0.1622, -0.4939 vv 0.1437, -0.5022 vv 0.1146),
      BezierTail(-0.5055 vv 0.1348, -0.5095 vv 0.1422, -0.5103 vv 0.1569), BezierTail(-0.495 vv 0.1739, -0.4934 vv 0.207, -0.5264 vv 0.2144),
      BezierTail(-0.5284 vv 0.1973, -0.5278 vv 0.1933, -0.5241 vv 0.1793), BezierTail(-0.5396 vv 0.1885, -0.5614 vv 0.1936, -0.576 vv 0.1806),
      BezierTail(-0.5661 vv 0.1699, -0.5509 vv 0.1606, -0.5273 vv 0.1722), BezierTail(-0.5329 vv 0.154, -0.5474 vv 0.1571, -0.5672 vv 0.164),
      BezierTail(-0.5551 vv 0.1412, -0.5398 vv 0.1372, -0.5228 vv 0.1398), BezierTail(-0.514 vv 0.1165, -0.5136 vv 0.09873, -0.5395 vv 0.06473),
      BezierTail(-0.5383 vv 0.08586, -0.5398 vv 0.1016, -0.5566 vv 0.1187), BezierTail(-0.571 vv 0.1328, -0.5826 vv 0.1181, -0.5602 vv 0.08676),
      BezierTail(-0.5738 vv 0.0968, -0.5892 vv 0.1172, -0.5939 vv 0.1376), BezierTail(-0.5984 vv 0.1124, -0.5943 vv 0.08271, -0.5804 vv 0.06608),
      BezierTail(-0.587 vv 0.05904, -0.5945 vv 0.06683, -0.6056 vv 0.08406), BezierTail(-0.6014 vv 0.02891, -0.5778 vv 0.01827, -0.5462 vv 0.03056),
      BezierTail(-0.5453 vv 0.0002905, -0.5453 vv -0.02774, -0.5435 vv -0.06431),
      BezierTail(-0.562 vv -0.03778, -0.5853 vv -0.018, -0.5984 vv -0.01305),
      BezierTail(-0.6024 vv -0.02789, -0.5871 vv -0.04722, -0.5786 vv -0.05801),
      BezierTail(-0.5916 vv -0.05531, -0.62 vv -0.03373, -0.62 vv -0.03373), BezierTail(-0.6228 vv -0.05831, -0.591 vv -0.08109, -0.5705 vv -0.09128),
      BezierTail(-0.5946 vv -0.09023, -0.6053 vv -0.08109, -0.6209 vv -0.0661), BezierTail(-0.6206 vv -0.1343, -0.547 vv -0.1225, -0.5332 vv -0.112),
      BezierTail(-0.5314 vv -0.1455, -0.5288 vv -0.1843, -0.527 vv -0.2179), BezierTail(-0.5478 vv -0.2143, -0.5462 vv -0.208, -0.564 vv -0.2064),
      BezierTail(-0.6134 vv -0.2045, -0.6526 vv -0.1471, -0.6656 vv -0.1049), BezierTail(-0.6693 vv -0.1118, -0.6663 vv -0.1191, -0.6697 vv -0.1276),
      BezierTail(-0.6778 vv -0.1069, -0.688 vv -0.08015, -0.7017 vv -0.0677),
      BezierTail(-0.6982 vv -0.07977, -0.6979 vv -0.09205, -0.6991 vv -0.1146),
      BezierTail(-0.7038 vv -0.09999, -0.7082 vv -0.09551, -0.7085 vv -0.07834),
      BezierTail(-0.7082 vv -0.06516, -0.6958 vv -0.05544, -0.6965 vv -0.0369),
      BezierTail(-0.697 vv -0.02336, -0.7093 vv 0.005975, -0.7111 vv 0.02869), BezierTail(-0.7171 vv 0.005312, -0.7209 vv -0.01933, -0.73 vv -0.0338),
      BezierTail(-0.7255 vv -0.008837, -0.7269 vv 0.008388, -0.7192 vv 0.02519),
      BezierTail(-0.7104 vv 0.04287, -0.7028 vv 0.05866, -0.7087 vv 0.07651), BezierTail(-0.7144 vv 0.06962, -0.7124 vv 0.06335, -0.7267 vv 0.0466),
      BezierTail(-0.7298 vv 0.06482, -0.7083 vv 0.09397, -0.6874 vv 0.1057), BezierTail(-0.6726 vv 0.1135, -0.654 vv 0.1412, -0.6661 vv 0.1603),
      BezierTail(-0.68 vv 0.1503, -0.6862 vv 0.1369, -0.7058 vv 0.1139), BezierTail(-0.6918 vv 0.1685, -0.6555 vv 0.1828, -0.6121 vv 0.183),
      BezierTail(-0.6025 vv 0.183, -0.5831 vv 0.1865, -0.5776 vv 0.1992), BezierTail(-0.5899 vv 0.1945, -0.6044 vv 0.1939, -0.6173 vv 0.1965),
      BezierTail(-0.6079 vv 0.2102, -0.5881 vv 0.2084, -0.5697 vv 0.2085), BezierTail(-0.5553 vv 0.2086, -0.5327 vv 0.2106, -0.5236 vv 0.2311),
      BezierTail(-0.5412 vv 0.2235, -0.5687 vv 0.2219, -0.586 vv 0.2273), BezierTail(-0.5585 vv 0.2416, -0.5154 vv 0.2431, -0.4933 vv 0.2618),
      BezierTail(-0.5185 vv 0.2806, -0.5815 vv 0.2574, -0.6213 vv 0.2301), BezierTail(-0.6102 vv 0.2403, -0.5926 vv 0.2583, -0.5829 vv 0.2729),
      BezierTail(-0.6047 vv 0.2833, -0.6598 vv 0.2223, -0.6787 vv 0.1861), BezierTail(-0.6967 vv 0.1759, -0.7039 vv 0.16, -0.7109 vv 0.1488),
      BezierTail(-0.7013 vv 0.1813, -0.7003 vv 0.2048, -0.6923 vv 0.2315), BezierTail(-0.7541 vv 0.2103, -0.7284 vv 0.09618, -0.7418 vv 0.06888),
      BezierTail(-0.7403 vv 0.09902, -0.7415 vv 0.1377, -0.7539 vv 0.1577), BezierTail(-0.773 vv 0.1432, -0.7745 vv 0.05778, -0.7566 vv -0.01333),
      BezierTail(-0.7631 vv 0.005703, -0.7753 vv 0.02347, -0.7792 vv 0.04662),
      BezierTail(-0.8073 vv -0.004719, -0.7627 vv -0.06529, -0.7253 vv -0.1131),
      BezierTail(-0.7534 vv -0.0985, -0.7812 vv -0.067, -0.7995 vv -0.0406), BezierTail(-0.7944 vv -0.1325, -0.6985 vv -0.1516, -0.6836 vv -0.1742),
      BezierTail(-0.7038 vv -0.1648, -0.7425 vv -0.1461, -0.7589 vv -0.1657), BezierTail(-0.7322 vv -0.1718, -0.7109 vv -0.1789, -0.6937 vv -0.1902),
      BezierTail(-0.6688 vv -0.2213, -0.6216 vv -0.2349, -0.5395 vv -0.2383), LineTail(-0.5395 vv -0.2383)).fill(Colour(0xFFffc726))
    
    Arr(greenRectangle, blueRectangle, redTriangle, olive)
  }
}