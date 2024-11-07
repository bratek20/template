// DO NOT EDIT! Autogenerated by HLA tool

namespace Fishing.Web {
    export class FishingWebClientConfig {
        constructor(
            readonly value: HttpClientConfig
        ) {}
    }

    export class FishingApiCatchFishRequest {
        private lure = new Lure
        getLure(): Lure {
            return this.lure
        }
        static create(lure: Lure): FishingApiCatchFishRequest {
            const instance = new FishingApiCatchFishRequest()
            instance.lure = lure
            return instance
        }
    }

    export class FishingApiCatchFishResponse {
        private value = new CaughtFish
        getValue(): CaughtFish {
            return this.value
        }
    }
}