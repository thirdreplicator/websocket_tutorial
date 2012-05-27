(use 'lamina.core 'aleph.http)

(def broadcast-channel (channel))

(defn chat-handler [ch handshake]
  (siphon ch broadcast-channel)
  (siphon broadcast-channel ch))

(receive-all broadcast-channel #(println %))

(start-http-server chat-handler {:port 9000 :websocket true})
