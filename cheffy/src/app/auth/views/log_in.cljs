(ns app.auth.views.log-in
  (:require [reagent.core :as r] 
            [app.components.page-nav :refer [page-nav]]
            ["@smooth-ui/core-sc" :refer [Row Col FormGroup Label Input]]))


(defn log-in
  []
  (let [initial-values {:email "" :password ""}
        values (r/atom initial-values)]
    ;; render function
    (fn []
      [:> Row {:justify-content "center"}
       [:> Col {:xs 12 :sm 6}
        [page-nav {:center "Log In"}]
        [:> FormGroup
         [:> Label {:html-for :email} "Email"]
         [:> Input {:control true
                    :id :email
                    :type "email"
                    :value (:email @values)
                    :on-change #(swap! values assoc :email (.. % -target -value))}]]
        [:> FormGroup
         [:> Label {:html-for :password} "password"]
         [:> Input {:control true
                    :id :password
                    :type "password"
                    :value (:password @values)
                    :on-change #(swap! values assoc :password (.. % -target -value))}]]]])))
