(ns app.core
  (:require [reagent.core :as r]
            ;; string import from npm
            [re-frame.core :as rf]
            [app.db]
            ;; -- auth --
            [app.auth.views.profile :refer [profile]]
            [app.auth.views.log-in :refer [log-in]]
            [app.auth.views.sign-up :refer [sign-up]]
            [app.auth.events]
            [app.auth.subs]
            ;; --become a chef--
            [app.become-a-chef.views.become-a-chef :refer [become-a-chef]]
            ;; -- inbox --
            [app.inbox.views.inboxes :refer [inboxes]]
            ;; -- inbox --
            [app.recipes.views.recipes :refer [recipes]]
            ;; --nav---
            [app.nav.views.nav :refer [nav]]
            [app.nav.events]
            [app.nav.subs]
            [app.theme :refer [cheffy-theme]]
            ["@smooth-ui/core-sc" :refer [Grid Row Col Normalize ThemeProvider Button]]))


;; page switcher
(defn pages
  [page-name]
  (case page-name
    :profile [profile]
    :become-a-chef [become-a-chef]
    :inboxes [inboxes]
    :recipes [recipes]
    :sign-up [sign-up]
    :log-in [log-in]
    [log-in]
    ))


(defn app
  []
  (let [active-nav @(rf/subscribe [:active-nav])]
    [:<>
     ;; :> == r/adapt-react-class
      [:> Normalize]
      [:> ThemeProvider {:theme cheffy-theme}
       [:> Grid {:fluid false}]
         [:> Row
          [:> Col
           [nav]
           [pages active-nav]]]]]))


(defn ^:dev/after-load start
  []
  (js/console.log "start")
  (r/render [app]
    (.getElementById js/document "app")))

(defn ^:export init
  []
  (js/console.log "init")
  (rf/dispatch-sync [:initialize-db])
  (start)
  )
