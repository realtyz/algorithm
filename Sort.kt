package edu.hzau.kpi

/**
 * 选择排序:
 * 每次在未排序的序列中选择一个最小的，放在未排序序列的最前端
 */
fun selectionSort(arr: IntArray) {
    var i = 0
    while (i < arr.size) {
        var min = arr[i]
        var minIdx = i
        var j = i + 1
        while (j < arr.size) {
            if (arr[j] < min) {
                min = arr[j]
                minIdx = j
            }
            j++
        }
        arr[minIdx] = arr[i]
        arr[i] = min
        i++
    }
}

/**
 * 冒泡排序:
 * 每次扫描都会将未排序部分中最大的元素放置到未排序部分的末尾
 */
fun bubbleSort(arr: IntArray) {
    var end = arr.size - 1
    while (end > 0) {
        var i = 0
        while (i < end) {
            if (arr[i] > arr[i + 1]) {
                var tmp = arr[i]
                arr[i] = arr[i + 1]
                arr[i + 1] = tmp
            }
            i ++
        }
        end --
    }
}

/**
 * 插入排序:
 * 数组前部分是有序的，每次将无序部分的第一个元素插入到有序部分中，使用二分查找找到正确的插入位置，始终保持前部分有序
 */
fun insertionSort(arr: IntArray) {
    var i = 1
    while (i < arr.size) {
        var l = 0
        var r = i
        while (l < r) {
            var mid = (l + r) / 2
            if (arr[mid] > arr[i]) {
                r = mid  // 注意此处与二分查找的区别(二分查找是r = mid - 1)
            } else {
                l = mid + 1
            }
        }

        var tmp = arr[i]
        var k = i - 1
        while (r <= k) {
            arr[k + 1] = arr[k]
            k--
        }
        arr[r] = tmp
        i++
    }
}

/**
 * 归并排序（递归版本）：
 * 空间复杂度太高
 */
fun mergeSort1(arr: IntArray) {
    if (arr.size == 1 || arr.isEmpty()) {
        return
    }

    var left = arr.copyOfRange(0, arr.size / 2)
    var right = arr.copyOfRange(arr.size / 2, arr.size)
    mergeSort1(left)
    mergeSort1(right)

    var idx = 0
    var lIdx = 0
    var rIdx = 0
    while (idx < arr.size) {
        if (lIdx == left.size) {
            arr[idx] = right[rIdx]
            idx++
            rIdx++
            continue
        }
        if (rIdx == right.size) {
            arr[idx] = left[lIdx]
            idx++
            lIdx++
            continue
        }
        if (left[lIdx] < right[rIdx]) {
            arr[idx] = left[lIdx]
            lIdx++
        } else {
            arr[idx] = right[rIdx]
            rIdx++
        }
        idx++
    }
}

/**
 * 快速排序
 */
fun quickSort(array: IntArray, start: Int, end: Int) {
    if (end - start <= 0) {
        return
    }

    var target = array[start]
    var l = start
    var r = end

    while (l < r) {  // 先从右往左，后从左往右，如此往复
        while (l < r) {
            if (array[r] < target) {
                array[l] = array[r]
                break
            } else {
                r--
            }
        }
        while (l < r) {
            if (array[l] > target) {
                array[r] = array[l]
                break
            } else {
                l++
            }
        }
    }

    array[l] = target

    quickSort(array, start, l - 1)
    quickSort(array, l + 1, end)
}

fun main() {

    var x = 0
    var arr = IntArray(100)
    while (x < 100) {
        arr[x] = (0..100).random()
        x++
    }
    println(arr.contentToString())
    println("--------------")
    quickSort(arr, 0, arr.size - 1)
    println(arr.contentToString())
}