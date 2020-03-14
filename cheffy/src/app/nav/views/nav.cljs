(ns app.nav.views.nav
  (:require [app.nav.views.authenticated :refer [authenticated]]
            [app.nav.views.public :refer [public]]))

(defn parse-auth-param
  [param-string]
  (if-let [res (re-find #"[\?|\&]auth\=([^&]+)" param-string)]
    (nth res 1)))


(defn get-auth
  []
  (boolean (parse-auth-param  (-> js/window .-location .-search))))

(defn nav
  []
  (let [user (get-auth)]
    (if user
      [authenticated]
      [public])))
