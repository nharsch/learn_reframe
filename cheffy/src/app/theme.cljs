(ns app.theme
  (:require ["@smooth-ui/core-sc" :refer [theme]]))

(def cheffy-theme (merge
                    ;; converts js object to clojurescript, converts obj fields to keywords
                    (js->clj theme :keywordize-keys true)
                    {:black "#243B53"
                     :primary "#27AB83"
                     :secondary "#F7D070"
                     :light "#D9E2EC"
                     :borderRadius "14px"
                     :borderRadiusSm "10px"
                     :borderRadiusLg "18px"
                     :modalHeaderBorderColor "white"}))
