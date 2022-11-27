<template>
  <GMapMap
      :center="center"
      :zoom="10"
      map-type-id="terrain"
      @bounds_changed="change"
      @click="clicked"
      style="width: 100vw; height: 20vw"
  >
    <GMapCluster :zoomOnClick="true">
      <GMapMarker
          :key="index"
          v-for="(m, index) in markers"
          :position="m.position"
          :clickable="true"
          :draggable="true"
          @dragend="move"
          @click="center = m.position"
      />

    </GMapCluster>
    <GMapCluster >
      <GMapPolygon
        :key="index"
        v-for="(m, index) in paths"
        :paths="m"
        />

<!--    <GMapPolygon-->
<!--        :paths="paths"-->
<!--    />-->
    </GMapCluster>
  </GMapMap>
</template>

<script>
export default {
  methods: {
    clicked(e) {
      console.log('click', e)
    },
    change(e) {
      console.log('change', e)
    },
    move(e) {
      console.log(e.latLng.lat())
      console.log(e.latLng.lng())
    }
  },
  mounted() {
    this.$axios.get("http://localhost:8081/abc").then(res => {
       this.paths = res.data.slice(0, 1000)
    })
  },
  data() {
    return {
      center: { lat: 51.093048, lng: 6.84212 },
      paths: [
        { lat: 51.00, lng: 6.77},
        { lat: 51.05, lng: 6.67},
        { lat: 51.12, lng: 6.87}
      ],
      markers: [
        {
          position: {
            lat: 51.093048,
            lng: 6.84212,
          },
        },
        {
          position: {
            lat: 51.198429,
            lng: 6.69529,
          },
        },
        {
          position: {
            lat: 51.165218,
            lng: 7.067116,
          },
        },
        {
          position: {
            lat: 51.09256,
            lng: 6.84074,
          },
        },
      ],
    };
  },
};
</script>

<style>
body {
  margin: 0;
}
</style>