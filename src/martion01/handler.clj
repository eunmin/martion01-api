(ns martion01.handler
  (:require [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]
            [schema.core :as s]))

(s/defschema Answers
  {:answers [s/Bool]
   :score s/Int})

(def app
  (api
   {:swagger
    {:ui "/"
     :spec "/swagger.json"
     :data {:info {:title "Martion01"
                   :description "Compojure Api example"}
            :tags [{:name "api", :description "some apis"}]}}}

   (context "/v1" []

     (POST "/answers" []
       :body [answers Answers]
       (println answers)
       (ok "hahahahah")))))
