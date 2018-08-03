import React from 'react';
import {
    ImageBackground,
} from 'react-native';

import ImageResizeMode from 'react-native/Libraries/Image/ImageResizeMode';

// noinspection JSUnusedGlobalSymbols
export default class ImageCapInset extends React.Component {
    static propTypes = ImageBackground.propTypes;
    static defaultProps = ImageBackground.defaultProps;
    render() {
        // noinspection JSUnresolvedVariable
        return (
            <ImageBackground {...this.props} resizeMode={ImageResizeMode.stretch} />
        );
    }
}