(defproject fdg "0.1.0-SNAPSHOT"
  :description "Functional Differential Programming"
  :url "http://github.com/pld/fdg"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]]
  :profiles {:dev {:dependencies [[midje "1.5.1"]]}}
  :plugins [[lein-midje "3.0.0"]])
