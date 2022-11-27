import {createApp} from "vue";
import App from "./App.vue";
import VueGoogleMaps from "@fawmi/vue-google-maps";
import axios from "axios";

const app = createApp(App)
app.config.globalProperties.$axios=axios

app.use(VueGoogleMaps, {
    load: {
        key: ""
    }
}).mount("#app");

