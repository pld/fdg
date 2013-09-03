(ns fdg.core-test
  (:use [fdg.core]
        [midje sweet]))

(fact "Lfree implements the Lagrangian for a free particle"
      ((Lfree 4) {:velocity 2}) => 16/2)

(fact "sphere->R3 implements the transformation of coordinates from colatitude theta and longitude phi on the surfact of the sphere to rectangular coordinates in the embedding space"
      ((sphere->R3 2) {:coordinate [0 Math/PI]}) => [0.0 0.0 2.0])

(fact "F->C implements the derivation of a transformation of states from a coordinate transformation"
      ((F->C (sphere->R3 2)) {:coordinate [0 0]
                              :time 1
                              :velocity 2}) => [1 [0.0 0.0 2.0] 0.0])

(fact "Lsphere implements the Langrangian governing free motion on a sphere"
      (Lsphere `m `R) => anything)
