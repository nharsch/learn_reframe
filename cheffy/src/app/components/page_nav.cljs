(ns app.components.page-nav
  (:require ["@smooth-ui/core-sc" :refer [Box Button Typography]]
            ["styled-icons/fa-solid/ChevronLeft" :refer [ChevronLeft]]))


(defn page-nav
  [{:keys [left ;; has an :href
           center
           right]}]
  [:> Box {:py 20
           :display "flex"
           :justify-content "space-between"}
   [:> Box
     (when left
       [:> Button {:as "a" :my 20 :variant "light" :href left}
         [:> ChevronLeft {:size 16}]])]
   [:> Box
     [:>
       Typography {:variant "h2"
                   :py 20
                   :font-weight 700}
       center]]
   [:> Box
    (when right
      right)]
   ])

()
