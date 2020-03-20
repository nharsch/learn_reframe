(ns app.nav.views.nav
  (:require [app.nav.views.authenticated :refer [authenticated]]
            [re-frame.core :as rf]
            ["@smooth-ui/core-sc" :refer [Box]] 
            [app.nav.views.public :refer [public]]))

(defn parse-auth-param
  [param-string]
  (if-let [res (re-find #"[\?|\&]auth\=([^&]+)" param-string)]
    (nth res 1)))



(defn nav
  []
  (let [logged-in? @(rf/subscribe [:logged-in?])]
    [:> Box {:display "flex"
             :justify-content "flex-start"
             :py 1}
      (if logged-in?
          [authenticated]
          [public])]))
