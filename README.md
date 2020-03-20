![alt learn-re-frame-logo](https://res.cloudinary.com/schae/image/upload/f_auto,q_80,r_16/v1549283297/cheffy/1200x680.png)

# Dev Env Startup

From (shadow-cljs docs)[https://shadow-cljs.github.io/docs/UsersGuide.html#editor_integration]

14.6.3. Connecting Fireplace.vim to REPL Server
Open a ClojureScript source file in Vim/Neovim and execute the following command to connect Fireplace.vim to the REPL server (note the port for the REPL server, 3333, specified in shadow-cljs.edn):

```
:Connect 3333
=>
Connected to nrepl://localhost:3333/
Scope connection to: ~/code/clojurescript/acme-app (ENTER)
```

This creates a Clojure (instead of ClojureScript) REPL session. Execute the following command to add ClojureScript support to the session (note the Shadow-CLJS build ID, frontend, specified in shadow-cljs.edn):

```
:CljEval (shadow/repl :app)

=>
To quit, type: :cljs/quit
[:selected :frontend]
Press ENTER or type command to continue
```

# NJH Notes

## (Reagent)[https://reagent-project.github.io/]: CLJS interface to React

declarative style
```
(defn simple-component []
  [:div
   [:p "I am a component!"]
   [:p.someclass
    "I have " [:strong "bold"]
    [:span {:style {:color "red"}} " and red "] "text."]])
```

`:>` == `reagent.core/adapt-react-class`

```
(defn react-component []
    [:> ReactClass {...props}])
```

Project uses smooth ui JS/React lib

## (Re-frame)[https://github.com/day8/re-frame] for state management

Components can subscribe to slices of app state

Event Dispatch -> Event Handling -> Effect Handling -> Query -> View -> Dom

Event Handlers return new state

Effect Handlers update state and trigger another event

## Shadow-Cljs

Hot code reloading, repl goodness, nifty toolbar.


# [learnreframe.com](https://www.learnreframe.com)

Learn re-frame a pattern for writing SPAs (Single-Page Applications) in ClojureScript, using Reagent. Build Cheffy; AirBnB for chefs. It includes CRUD operations, idiomatic code and advanced patterns. Step-by-step, concept-by-concept we'll learn how to work with app-db, effects, subscriptions and much more. Upon completion of the course you will be a hotshot when it comes to re-frame.

## Course files

The code in this repo is split into two folders - `cheffy` - starting point of the videos (this is what you should open when you start to code along with the vidoes) and - `increments` - code for the start of each video (if you get lost somewhere along the way just copy the content of the video you are starting and continue).

### Clone

```shell
$ git clone git@github.com:jacekschae/learn-re-frame-course-files.git

$ cd learn-re-frame-course-files/cheffy/
```

### Install

```shell
learn-re-frame-course-files/cheffy/ $ npm install
```

or with yarn

```shell
learn-re-frame-course-files/cheffy/ $ yarn install
```

### Run development server

```shell
learn-re-frame-course-files/cheffy/ $ npm run dev
```

or with yarn

```shell
learn-re-frame-course-files/cheffy/ $ yarn dev
```

## License

Copyright © 2019 Jacek Schae
