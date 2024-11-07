// DO NOT EDIT! Autogenerated by HLA tool

class FishId {
    constructor(
        public readonly value: string
    ) {}

    equals(other: FishId): boolean {
        return this.value === other.value
    }

    toString(): string {
        return this.value.toString()
    }
}

class CaughtFish {
    private id = STRING
    private name = STRING
    private points = NUMBER

    static create(
        id: FishId,
        name: string,
        points: number,
    ): CaughtFish {
        const instance = new CaughtFish()
        instance.id = id.value
        instance.name = name
        instance.points = points
        return instance
    }

    getId(): FishId {
        return new FishId(this.id)
    }

    getName(): string {
        return this.name
    }

    getPoints(): number {
        return this.points
    }
}

class Lure {
    private fishId = STRING

    static create(
        fishId: FishId,
    ): Lure {
        const instance = new Lure()
        instance.fishId = fishId.value
        return instance
    }

    getFishId(): FishId {
        return new FishId(this.fishId)
    }
}

class FishContent {
    private id = STRING
    private name = STRING
    private minPoints = NUMBER
    private maxPoints = NUMBER

    static create(
        id: FishId,
        name: string,
        minPoints: number,
        maxPoints: number,
    ): FishContent {
        const instance = new FishContent()
        instance.id = id.value
        instance.name = name
        instance.minPoints = minPoints
        instance.maxPoints = maxPoints
        return instance
    }

    getId(): FishId {
        return new FishId(this.id)
    }

    getName(): string {
        return this.name
    }

    getMinPoints(): number {
        return this.minPoints
    }

    getMaxPoints(): number {
        return this.maxPoints
    }
}

class Fishery {
    private fishes = [new FishContent]

    static create(
        fishes: FishContent[],
    ): Fishery {
        const instance = new Fishery()
        instance.fishes = fishes
        return instance
    }

    getFishes(): FishContent[] {
        return this.fishes
    }
}