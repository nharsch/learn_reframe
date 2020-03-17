(ns app.nav.views.nav
  (:require [app.nav.views.authenticated :refer [authenticated]]
            [re-frame.core :as rf]
            [app.nav.views.public :refer [public]]))

(defn parse-auth-param
  [param-string]
  (if-let [res (re-find #"[\?|\&]auth\=([^&]+)" param-string)]
    (nth res 1)))



(defn nav
  []
  (let [logged-in? @(rf/subscribe [:logged-in?])] ;; TODO: state
    (if logged-in?
      [authenticated]
      [public])))
