(ns app.auth.events
  (:require [re-frame.core :refer [reg-event-fx reg-event-db]]))

(reg-event-fx
  :log-in ;; cofx {:db db :dispatch [:set-active-nav :saved]
  (fn [{:keys [db]} [_ {:keys [email password]}]]
    (let [user (get-in db [:users email])
          correct-password? (= (get-in user [:profile :password]) password)]
      (cond
        (not user) {:db (assoc-in db [:errors :email] "User not found")}
        (not correct-password?) {:db (assoc-in db [:errors :email] "Wrong password")}
        correct-password? {:db (-> db
                             (assoc-in [:auth :uid] email)
                             (update-in [:errors] dissoc :email))
                           :dispatch [:set-active-nav :profile]}))))


(reg-event-fx
  :log-out
  (fn [{:keys [db]} _]
    {:db (assoc-in db [:uid] nil)
     :dispatch [:set-active-nav :recipes]}))

(reg-event-db
  :update-profile
  (fn [db [_ profile]]
    (let [uid (get-in db [:auth :uid])]
      (update-in db [:users uid :profile] merge (select-keys profile [:fist-name :last-name])))))

(reg-event-fx
  :delete-account
  (fn [{:keys [db]} _]
   (let [uid (get-in db [:auth :uid])]
    {:db (dissoc db [:users uid])
     :dispatch [:log-out]})))
