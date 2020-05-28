/**
 * @param fmt 格式化字符串样式 yyyy-MM-dd HH:mm:ss
 * @param date JavaScript 当中的 Date 对象
 * @returns {*}
 */
function dateFormat(fmt, date) {
    const opt = {
        'y+': date.getFullYear().toString(),        // 年
        'M+': (date.getMonth() + 1).toString(),     // 月
        'd+': date.getDate().toString(),            // 日
        'H+': date.getHours().toString(),           // 时
        'm+': date.getMinutes().toString(),         // 分
        's+': date.getSeconds().toString()          // 秒
    };

    /**
     * k -> y+ M+ d+ H+ m+ s+
     *
     * 依次用 k 去匹配 fmt 当中的字符串，如果有的话就执行替换操作。
     */
    let ret;
    for (let k in opt) {
        ret = new RegExp('(' + k + ')').exec(fmt);
        if (ret) {
            // ret[1] 是匹配结果，如果传入的 fmt 当中过长就用 0 来进行替补
            fmt = fmt.replace(ret[1], (ret[1].length === 1) ? (opt[k]) : (opt[k].padStart(ret[1].length, '0')));
        }
    }

    return fmt;
}
