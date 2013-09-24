(ns fdg.core)

(defn deriv [n]
  "partial derivative with respect to the nth argument"
  ;; TODO Implement the partial derivative
  (fn [F] (fn [state] (nth (F state) n))))

(defmacro square [x] `(* ~x ~x))

(defn Lfree [mass]
  "Langrangian for a free particle"
  (fn [state] (* 1/2 mass (square (:velocity state)))))

(defn sphere->R3 [R]
  "Transformation of coordinates from colatitude and longitude on the surface
   of the sphere to rectangular coordinates in the embedding space"
  (fn [state]
    (let [q (:coordinate state)
          theta (q 0)
          phi (q 1)]
      [(* R (Math/sin theta) (Math/cos phi))
       (* R (Math/sin theta) (Math/sin phi))
       (* R (Math/cos theta))])))

(defn F->C [F]
  "Derivation of a transformation of states from a coordinate transformation"
  (fn [state]
    [(:time state)
     (F state)
     (+ (((deriv 0) F) state)
        (* (((deriv 1) F) state)
           (:velocity state)))]))

(defn Lsphere [m R]
  "Lagrangian governing free motion on a sphere of radius R"
  (comp (Lfree m) (F->C (sphere->R3 R))))
